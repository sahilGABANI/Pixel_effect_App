package com.example.pixeleffectapp;

import static com.example.pixeleffectapp.Imageedit.efect_img;
import static com.example.pixeleffectapp.Imageedit.frame_layout;
import static com.example.pixeleffectapp.Imageedit.selected_data_recycle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class All_effect_Adapter extends RecyclerView.Adapter<All_effect_Adapter.ViewData> {
    int[] effect_icon;
    String[] effect_icon_text;
    Activity activity;



    public All_effect_Adapter(Activity activity, int[] effect_icon, String[] effect_icon_text) {
        this.activity = activity;
        this.effect_icon_text = effect_icon_text;
        this.effect_icon = effect_icon;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.effect_design, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        holder.icon.setImageResource(effect_icon[position]);
        holder.icon_text.setText(effect_icon_text[position]);
        holder.back_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 2) {
                    int[] glare = {R.drawable.flare_01, R.drawable.flare_02, R.drawable.flare_03, R.drawable.flare_04, R.drawable.flare_05, R.drawable.flare_06};
                    selected_data_recycle.setVisibility(View.INVISIBLE);
                    Glare_Aadpter glare_aadpter = new Glare_Aadpter(activity, glare);
                    RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
                    selected_data_recycle.setAdapter(glare_aadpter);
                    selected_data_recycle.setLayoutManager(layoutManager3);

                    selected_data_recycle.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    selected_data_recycle.setVisibility(View.INVISIBLE);
                    AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(activity, 0, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                            selected_data_recycle.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {

                            efect_img.setColorFilter(color);
                            selected_data_recycle.setVisibility(View.VISIBLE);


                        }
                    });

                    ambilWarnaDialog.show();
                } else if (position == 0) {
                    int[] pixel_img = {R.drawable.pixel_1, R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_4, R.drawable.pixel_5, R.drawable.pixel_6, R.drawable.pixel_8, R.drawable.pixel_9, R.drawable.pixel_10, R.drawable.pixel_11, R.drawable.pixel_12, R.drawable.pixel_13, R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21, R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28, R.drawable.pixel_29, R.drawable.pixel_30, R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33, R.drawable.pixel_34, R.drawable.pixel_35, R.drawable.pixel_36, R.drawable.pixel_37, R.drawable.pixel_38, R.drawable.pixel_39, R.drawable.pixel_40, R.drawable.pixel_41};
                    selected_data_recycle.setVisibility(View.INVISIBLE);
                    Selected_effect_Adapter selected_effect_adapter = new Selected_effect_Adapter(activity, pixel_img);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
                    selected_data_recycle.setAdapter(selected_effect_adapter);
                    selected_data_recycle.setLayoutManager(layoutManager1);
                    selected_data_recycle.setVisibility(View.VISIBLE);

                } else if (position == 6) {
                    selected_data_recycle.setVisibility(View.INVISIBLE);

                    frame_layout.setRotation(frame_layout.getRotation()+ 90);

                } else if (position == 7) {
                    selected_data_recycle.setVisibility(View.INVISIBLE);

                    float  scal  =  frame_layout.getScaleX();

                    if (scal == 1)
                    {
                        frame_layout.setScaleX(-1f);
                    }
                    else if(scal == -1)
                    {
                        frame_layout.setScaleX(1.0f);
                    }

                    selected_data_recycle.setVisibility(View.VISIBLE);
                }
                else  if (position == 5)
                {
                    selected_data_recycle.setVisibility(View.INVISIBLE);
                    int [] sticker_img = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,R.drawable.one_two,R.drawable.one_three,R.drawable.one_four,R.drawable.one_five,R.drawable.one_six,R.drawable.one_seven,R.drawable.one_eight,R.drawable.one_nine,R.drawable.twenty,R.drawable.twenty_one,R.drawable.twenty_two,R.drawable.twenty_three,R.drawable.twenty_four,R.drawable.twenty_five,R.drawable.twenty_six,R.drawable.twenty_seven,R.drawable.twenty_eight,R.drawable.twenty_nine,R.drawable.thirty,R.drawable.thirty_one,R.drawable.thirty_two,R.drawable.thirty_three,R.drawable.thirty_four,R.drawable.thirty_five,R.drawable.thirty_six,R.drawable.thirty_seven};
                    Sticker_Adapter  sticker_adapter = new Sticker_Adapter(activity, sticker_img);
                    RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
                    selected_data_recycle.setAdapter(sticker_adapter);
                    selected_data_recycle.setLayoutManager(layoutManager2);
                    selected_data_recycle.setVisibility(View.VISIBLE);
                }

                else if (position == 3) {

                    int[] pixel_img = {R.drawable.pixel_1, R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_4, R.drawable.pixel_5, R.drawable.pixel_6, R.drawable.pixel_8, R.drawable.pixel_9, R.drawable.pixel_10, R.drawable.pixel_11, R.drawable.pixel_12, R.drawable.pixel_13, R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21, R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28, R.drawable.pixel_29, R.drawable.pixel_30, R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33, R.drawable.pixel_34, R.drawable.pixel_35, R.drawable.pixel_36, R.drawable.pixel_37, R.drawable.pixel_38, R.drawable.pixel_39, R.drawable.pixel_40, R.drawable.pixel_41};
                    selected_data_recycle.setVisibility(View.INVISIBLE);
                    Filter_Adapter filter_adapter = new Filter_Adapter(activity,pixel_img);
                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
                    selected_data_recycle.setAdapter(filter_adapter);
                    selected_data_recycle.setLayoutManager(layoutManager1);
                    selected_data_recycle.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return effect_icon.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        private final ImageView icon;
        private final TextView icon_text;
        private final LinearLayout back_linear;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            icon_text = itemView.findViewById(R.id.icon_txt);
            back_linear = itemView.findViewById(R.id.back_linear);
        }
    }


}
