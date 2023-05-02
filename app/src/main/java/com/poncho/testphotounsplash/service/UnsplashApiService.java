package com.poncho.testphotounsplash.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class UnsplashApiService {

    private static final String BASE_URL = "https://api.unsplash.com";
    private static final String RANDOM_PHOTOS_ENDPOINT = "/photos/random";

    private static Gson gson;
    private OkHttpClient client;

    public UnsplashApiService(String accessKey) {
        client = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        client = client.newBuilder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    HttpUrl url = original.url().newBuilder()
                            .addQueryParameter("client_id", accessKey)
                            .build();

                    Request request = original.newBuilder()
                            .url(url)
                            .build();

                    return chain.proceed(request);
                })
                .build();
    }

    public void getRandomPhotos(int count, Callback callback) {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(BASE_URL + RANDOM_PHOTOS_ENDPOINT)).newBuilder();
        urlBuilder.addQueryParameter("count", String.valueOf(count));
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    public static Gson getGson() {
        return gson;
    }

}