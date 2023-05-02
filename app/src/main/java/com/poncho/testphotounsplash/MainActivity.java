package com.poncho.testphotounsplash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.poncho.testphotounsplash.model.UnsplashPhoto;
import com.poncho.testphotounsplash.service.ListRecyclerViewAdapter;
import com.poncho.testphotounsplash.service.UnsplashApiService;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String ACCESS_KEY = "ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UnsplashApiService unsplashApiService = new UnsplashApiService(ACCESS_KEY);
        unsplashApiService.getRandomPhotos(30, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Failed to fetch random photos", e);

                runOnUiThread(() -> {
                    Toast.makeText(MainActivity.this, "Failed to fetch random photos", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Log.e(TAG, "Failed to fetch random photos: " + response.message());

                    runOnUiThread(() -> {
                        Toast.makeText(MainActivity.this, "Failed to fetch random photos", Toast.LENGTH_SHORT).show();
                    });
                    return;
                }

                assert response.body() != null;
                String responseString = response.body().string();
                UnsplashPhoto[] photos = UnsplashApiService.getGson().fromJson(responseString, UnsplashPhoto[].class);
                startViewAdapter(photos);
            }

            private void startViewAdapter(UnsplashPhoto[] photos) {
                RecyclerView recyclerView = findViewById(R.id.recycler_view);

                List<UnsplashPhoto> photoList = new ArrayList<>(Arrays.asList(photos));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        RecyclerView recyclerView = findViewById(R.id.recycler_view);

                        ListRecyclerViewAdapter.OnStateClickListener stateClickListener = new ListRecyclerViewAdapter.OnStateClickListener() {
                            @Override
                            public void onStateClick(UnsplashPhoto unsplashPhoto, int position) {
                                Intent intent = new Intent(MainActivity.this, OpenImageActivity.class);
                                String fullUrl = unsplashPhoto.getUrls().getFull();
                                intent.putExtra("fullUrl", fullUrl);
                                startActivity(intent);
                            }
                        };
                        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter(photoList, getApplicationContext(), stateClickListener);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }

}