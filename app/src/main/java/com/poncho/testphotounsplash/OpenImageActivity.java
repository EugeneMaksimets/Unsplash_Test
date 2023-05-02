package com.poncho.testphotounsplash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.poncho.testphotounsplash.service.LoadImageFromUrl;

public class OpenImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private String fullSizeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_image);

        fullSizeUrl = getIntent().getStringExtra("fullUrl");
        imageView = findViewById(R.id.imageViewSecond);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int deviceWidth = displayMetrics.widthPixels;

        LoadImageFromUrl.loadImage(fullSizeUrl, imageView, deviceWidth);
    }

}