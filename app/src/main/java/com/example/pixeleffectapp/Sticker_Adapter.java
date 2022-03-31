package com.example.pixeleffectapp;

import static com.example.pixeleffectapp.Imageedit.frame_layout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Sticker_Adapter extends RecyclerView.Adapter<Sticker_Adapter.ViewData> {

    Activity activity;
    int[] sticker_img;
    private StickerView mCurrentView;
    public Sticker_Adapter(Activity activity, int[] sticker_img) {
        this.activity = activity;
        this.sticker_img = sticker_img;

    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.design1,parent,false);
        return new Sticker_Adapter.ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        holder.image.setImageResource(sticker_img[position]);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sticker_Create(sticker_img[position]);
            }
        });
        frame_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentView!=null)
                {
                    mCurrentView.setInEdit(false);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return sticker_img.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final LinearLayout linear;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            linear = itemView.findViewById(R.id.linear);
        }
    }

    public void sticker_Create(int sticker) {
        StickerView stickerView = new StickerView(activity);
        stickerView.setImageResource(sticker);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        frame_layout.addView(stickerView, layoutParams);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {

            @Override
            public void onDeleteClick() {
                frame_layout.removeView(stickerView);
            }

            @Override
            public void onEdit(StickerView stickerView) {
                mCurrentView.setInEdit(false);
                mCurrentView = stickerView;
                mCurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {

            }
        });
    }
    //
    private void setCurrentEdit(StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

}
