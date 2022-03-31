package com.example.pixeleffectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;

public class MyCreation extends AppCompatActivity {

    RecyclerView creation_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_creation);
        getSupportActionBar().hide();



        creation_recycle = findViewById(R.id.creation_recycle);
        Image();



    }

    void Image()
    {
        File folder = new File(Environment.getExternalStorageDirectory().toString() + "/Pixel Effect Photo/");
        if(folder.exists()) {
            File[] allFiles = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
                }
            });


            for (int i=0;i<allFiles.length;i++)
            {
                Log.e("TAG", "getAllImages: "+allFiles[i].getPath() );

                MyCreation_Adapter myCreation_adapter =  new MyCreation_Adapter(MyCreation.this,allFiles);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyCreation.this);
                creation_recycle.setLayoutManager(layoutManager);
                creation_recycle.setAdapter(myCreation_adapter);

            }
        }
        else
        {
            Toast.makeText(MyCreation.this, "Error", Toast.LENGTH_SHORT).show();
        }


    }

}