package com.example.srk.noice;

import android.Manifest;
import android.app.Activity;

import android.content.Intent;

import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;

import android.view.Menu;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    private EditText phoneNumber;
TextView t1,t2;
    private EditText To;
    private EditText Subject;
    private EditText Message;

    private Button email;

    private EditText smsBody;

    private Button smsManagerBtn;

    private Button smsSendToBtn;

    private Button smsViewBtn;

    private ImageButton imageButton;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sms);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);

        smsBody = (EditText) findViewById(R.id.smsBody);
        t1=(TextView)findViewById(R.id.sam);
        t2=(TextView)findViewById(R.id.nik);

imageButton=(ImageButton) findViewById(R.id.map);
        smsSendToBtn = (Button) findViewById(R.id.smsSIntent);
        To=(EditText)findViewById(R.id.to);
        Subject=(EditText)findViewById(R.id.subject);
        Message=(EditText)findViewById(R.id.message1);
        email=(Button) findViewById(R.id.gmail);

        t1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=t1.getText().toString();

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Sms.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }

        });
        t2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=t2.getText().toString();

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Sms.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }

        });





















        email.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=To.getText().toString();
                String subject=Subject.getText().toString();
                String message=Message.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
    }





    public void sendSmsByVIntent1(View v) {

        Intent smsVIntent = new Intent(Intent.ACTION_VIEW);

        smsVIntent.setType("vnd.android-dir/mms-sms");

        // extra fields for number and message respectively

        smsVIntent.putExtra("address", phoneNumber.getText().toString());

        smsVIntent.putExtra("sms_body", smsBody.getText().toString());

        try{

            startActivity(smsVIntent);

        } catch (Exception ex) {

            Toast.makeText(Sms.this, "Your sms has failed...",

                    Toast.LENGTH_LONG).show();

            ex.printStackTrace();

        }



    }
   public void map(View v)
   {
       startActivity(new Intent(this,MapsActivity.class));
   }
}
