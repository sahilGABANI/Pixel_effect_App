package com.example.pixeleffectapp;

import static com.example.pixeleffectapp.Imageedit.glary_img;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Glare_Aadpter extends RecyclerView.Adapter<Glare_Aadpter.ViewDate> {

Activity activity;
int[] glare;


    public Glare_Aadpter(Activity activity, int[] glare) {
        this.glare = glare;
        this.activity =activity;

    }

    @NonNull
    @Override
    public ViewDate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.design1,parent,false);
        return new ViewDate(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewDate holder, int position) {
        holder.image.setImageResource(glare[position]);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glary_img.setImageResource(glare[position]);
            }
        });

    }

    @Override
    public int getItemCount() {
        return glare.length;
    }

    class ViewDate extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final LinearLayout linear;

        public ViewDate(@NonNull View itemView) {
           super(itemView);
           image = itemView.findViewById(R.id.image);
           linear = itemView.findViewById(R.id.linear);
       }
   }


}
