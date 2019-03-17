package com.example.srk.noice;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText editText1, editText2;
    Button button1;
    CheckBox checkBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        button1 = (Button) findViewById(R.id.buttonLogin);
        checkBox=(CheckBox)findViewById(R.id.chkBox1);
    }

            public void onClick1(View view) {

          if(editText1.getText().toString().equals("admin")&&editText2.getText().toString().equals("admin")&&checkBox.isEnabled())
          {

              Intent intent = new Intent(this, Image1.class);
              startActivity(intent);
              Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
          }
          else
          {
              Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
          }

            }

    }



