package com.poncho.testphotounsplash.service;

import android.annotation.SuppressLint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.poncho.testphotounsplash.R;
import com.poncho.testphotounsplash.model.UnsplashPhoto;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewHolder> {

    private OnStateClickListener onClickListener;
    private LayoutInflater inflater;
    private List<UnsplashPhoto> photosList;

    public interface OnStateClickListener{
        void onStateClick(UnsplashPhoto unsplashPhoto, int position);
    }

    public ListRecyclerViewAdapter(List<UnsplashPhoto> photoList, Context context, OnStateClickListener onClickListener) {
        this.photosList = photoList;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public ListRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListRecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(photosList.get(position));
        UnsplashPhoto unsplashPhoto = photosList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(unsplashPhoto, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

}
