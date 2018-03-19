package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebBrowser extends AppCompatActivity {


    WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Building the web browser
        setContentView(R.layout.activity_web_browser);
       wv = (WebView)findViewById(R.id.webview);
       wv.setWebViewClient(new WebViewClient());
       wv.getSettings().getBuiltInZoomControls();
       //The URL that the web browser will land on
       wv.loadUrl("https://www.google.com/");

       //Testing Sending URL history to Main Activity
        //String message =  wv.getUrl();
        //Intent intent = getIntent();
        //intent.putExtra("message", message);


        //This is how you pass data from one page to another
        //String value = intent.getStringExtra("key");      //If it is a string you stored

    }

    //public void
}
