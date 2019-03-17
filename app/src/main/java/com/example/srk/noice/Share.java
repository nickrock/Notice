package com.example.srk.noice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Share extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/Notice-2184409978484390/?modal=admin_todo_tour");
        intent.setType("text/plain");

        startActivity(Intent.createChooser(intent, "choose app to share link or text"));

        startActivity(intent);
    }
}
