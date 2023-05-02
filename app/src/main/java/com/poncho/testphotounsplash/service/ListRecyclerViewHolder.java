package com.poncho.testphotounsplash.service;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.poncho.testphotounsplash.R;
import com.poncho.testphotounsplash.model.UnsplashPhoto;

public class ListRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageView;
    private final TextView textViewTop;
    private final TextView textViewBottom;

    public ListRecyclerViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_view);
        textViewTop = itemView.findViewById(R.id.text_view_top);
        textViewBottom = itemView.findViewById(R.id.text_view_bottom);
    }

    public void bind(UnsplashPhoto unsplashPhoto) {
        LoadImageFromUrl.loadImage(unsplashPhoto.getUrls().getSmall(), imageView, 500);

        textViewTop.setText(unsplashPhoto.getAltDescription());
        textViewBottom.setText("By :".concat(unsplashPhoto.getUser().getName()));
    }

}
