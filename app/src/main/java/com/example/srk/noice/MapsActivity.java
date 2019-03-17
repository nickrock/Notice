package com.example.srk.noice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapsActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        webView=(WebView)findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);


        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.loadUrl("https://www.google.com/maps/place/Jain+College+of+MCA+and+MBA/@15.80069,74.4735983,17z/data=!3m1!4b1!4m5!3m4!1s0x3bbf65952c5aeed3:0x964422eaa4f1c807!8m2!3d15.80069!4d74.475787");

    }
}
