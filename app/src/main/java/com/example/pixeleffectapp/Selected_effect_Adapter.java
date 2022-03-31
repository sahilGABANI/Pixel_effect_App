package com.example.pixeleffectapp;

import static com.example.pixeleffectapp.Imageedit.efect_img;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Selected_effect_Adapter extends RecyclerView.Adapter<Selected_effect_Adapter.ViewData> {

    Activity activity;
    int[] pixel_img;

    public Selected_effect_Adapter(Activity activity, int[] pixel_img) {
        this.activity = activity;
        this.pixel_img = pixel_img;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.design,parent,false);
        return new Selected_effect_Adapter.ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        holder.image.setImageResource(pixel_img[position]);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efect_img.setImageResource(pixel_img[position]);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pixel_img.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final LinearLayout linear;
        private final ImageView image;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.linear);
            image = itemView.findViewById(R.id.image);
        }
    }

}
