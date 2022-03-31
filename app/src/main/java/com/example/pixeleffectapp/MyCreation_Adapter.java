package com.example.pixeleffectapp;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.net.URI;

public class MyCreation_Adapter extends RecyclerView.Adapter<MyCreation_Adapter.ViewData> {

    File[] allFiles;
    Activity activity;
    public MyCreation_Adapter(MyCreation myCreation, File[] allFiles) {
        this.activity = myCreation;
        this.allFiles= allFiles;

    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.design4,parent,false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        holder.image.setImageURI(Uri.fromFile(allFiles[position]));

    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final ImageView image;
        LinearLayout share;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            share = itemView.findViewById(R.id.share);
        }
    }
}
