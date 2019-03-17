package com.example.srk.noice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AdminNav extends AppCompatActivity {
ImageButton imageButton1;
ImageButton imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_nav);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton3);

    }
           // public void add1(View v) {
              //  startActivity(new Intent(this,Image1.class));
            }
            //public void user1(View v) {
                //startActivity(new Intent(this, Userreg.class));







