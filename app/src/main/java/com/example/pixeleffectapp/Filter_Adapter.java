package com.example.pixeleffectapp;

import static com.example.pixeleffectapp.Imageedit.filter_img;
import static com.example.pixeleffectapp.Imageedit.frame_layout;
import static com.example.pixeleffectapp.Imageedit.glary_img;
import static com.example.pixeleffectapp.Imageedit.img;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Filter_Adapter extends RecyclerView.Adapter<Filter_Adapter.ViewData> {

    Activity activity;

    public Filter_Adapter(Activity activity, int[] pixel_img) {

        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.design3,parent,false);
        return new Filter_Adapter.ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {



        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0)
                {
                    Effects.applyEffectNone(img);
                }
                else if (position == 1)
                {
                    Effects.applyEffect1(img);
                }
                else if(position == 2)
                {
                    Effects.applyEffect2(img);
                }
                else if (position == 3)
                {
                    Effects.applyEffect3(img);
                }
                else if(position == 4)
                {
                    Effects.applyEffect4(img);
                }
                else if (position == 5)
                {
                    Effects.applyEffect5(img);
                }
                else if(position == 6)
                {
                    Effects.applyEffect6(img);
                }
                else if (position == 7)
                {
                    Effects.applyEffect7(img);
                }
                else if(position == 8)
                {
                    Effects.applyEffect8(img);
                }
                else if (position == 9)
                {
                    Effects.applyEffect9(img);
                }
                else if(position == 10)
                {
                    Effects.applyEffect10(img);
                }
                else if (position == 11)
                {
                    Effects.applyEffect11(img);
                }
                else if(position == 12)
                {
                    Effects.applyEffect12(img);
                }
                else if (position == 13)
                {
                    Effects.applyEffect13(img);
                }
                else if(position == 14)
                {
                    Effects.applyEffect14(img);
                }
                else if (position == 15)
                {
                    Effects.applyEffect15(img);
                }
                else if(position == 16)
                {
                    Effects.applyEffect16(img);
                }
                else if (position == 17)
                {
                    Effects.applyEffect17(img);
                }
                else if(position == 18)
                {
                    Effects.applyEffect18(img);
                }
                else if (position == 19)
                {
                    Effects.applyEffect19(img);
                }
                else if(position == 20)
                {
                    Effects.applyEffect20(img);
                }
                else if (position == 21)
                {
                    Effects.applyEffect21(img);
                }
                else if(position == 22)
                {
                    Effects.applyEffect22(img);
                }


            }
        });





    }

    @Override
    public int getItemCount() {
        return 22;
    }

    class ViewData extends RecyclerView.ViewHolder {
         ImageView image;
         LinearLayout linear;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            linear = itemView.findViewById(R.id.linear);
        }
    }
}
