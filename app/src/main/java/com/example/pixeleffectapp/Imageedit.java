package com.example.pixeleffectapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Imageedit extends AppCompatActivity {

    public static RecyclerView selected_data_recycle, all_effect_recycle;
    public static ImageView efect_img, glary_img,img;
    ImageView camera_img;
    TextView save;
    String filename;
    public static File file;
    public static FrameLayout frame_layout;
    public static ImageView filter_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageedit);
        getSupportActionBar().hide();
        Binding();




        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        if(key.equals("1"))
        {
            Uri uri = intent.getParcelableExtra("uri");
            img.setImageURI(uri);
        }
        else
        {
            Bitmap bit = intent.getParcelableExtra("photo");
            img.setImageBitmap(bit);
        }





//        Intent intent1 = getIntent();



        int[] effect_icon = {R.drawable.effect_ic, R.drawable.colorbucket_ic, R.drawable.glare_ic, R.drawable.filter_ic, R.drawable.text_ic, R.drawable.sticker_ic, R.drawable.rotate_ic, R.drawable.flip_ic};

        String[] effect_icon_text = {"Effect", "Color", "Glare", "Filter", "Text", "Sticker", "Rotate", "Flip"};

        All_effect_Adapter all_effect_adapter = new All_effect_Adapter(Imageedit.this, effect_icon, effect_icon_text);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Imageedit.this, LinearLayoutManager.HORIZONTAL, false);
        all_effect_recycle.setLayoutManager(layoutManager);
        all_effect_recycle.setAdapter(all_effect_adapter);


        int[] pixel_img = {R.drawable.pixel_1, R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_4, R.drawable.pixel_5, R.drawable.pixel_6, R.drawable.pixel_8, R.drawable.pixel_9, R.drawable.pixel_10, R.drawable.pixel_11, R.drawable.pixel_12, R.drawable.pixel_13, R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21, R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28, R.drawable.pixel_29, R.drawable.pixel_30, R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33, R.drawable.pixel_34, R.drawable.pixel_35, R.drawable.pixel_36, R.drawable.pixel_37, R.drawable.pixel_38, R.drawable.pixel_39, R.drawable.pixel_40, R.drawable.pixel_41};
        Selected_effect_Adapter selected_effect_adapter = new Selected_effect_Adapter(Imageedit.this, pixel_img);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Imageedit.this, LinearLayoutManager.HORIZONTAL, false);
        selected_data_recycle.setAdapter(selected_effect_adapter);
        selected_data_recycle.setLayoutManager(layoutManager1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                frame_layout.setDrawingCacheEnabled(true);
                frame_layout.buildDrawingCache(true);

                Bitmap bitmap = Bitmap.createBitmap(frame_layout.getDrawingCache());

                Download_image(bitmap);

                frame_layout.setDrawingCacheEnabled(false);
                frame_layout.buildDrawingCache(false);
            }
        });
    }

    void Binding() {
        img = findViewById(R.id.img);
        selected_data_recycle = findViewById(R.id.selected_data_recycle);
        all_effect_recycle = findViewById(R.id.all_effect_recycle);
        efect_img = findViewById(R.id.efect_img);
        glary_img = findViewById(R.id.glary_img);
        camera_img = findViewById(R.id.camera_img);
        save = findViewById(R.id.save);
        frame_layout = findViewById(R.id.frame_layout);
        filter_img = findViewById(R.id.filter_img);
    }

    void Download_image(Bitmap bitmap) {
        filename = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()).toString();

        File direct = new File(Environment.getExternalStorageDirectory() + "/Pixel Effect Photo");
        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/Pixel Effect Photo/");
            wallpaperDirectory.mkdirs();
        }


        file = new File("/sdcard/Pixel Effect Photo/", filename + ".png");

        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }





}