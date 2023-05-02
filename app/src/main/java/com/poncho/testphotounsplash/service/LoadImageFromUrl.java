package com.poncho.testphotounsplash.service;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LoadImageFromUrl {

    public static void loadImage(String url, ImageView imageView, int width) {
        try {
            Picasso.get()
                    .load(url)
                    .resize(width, 0)
                    .into(imageView);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
