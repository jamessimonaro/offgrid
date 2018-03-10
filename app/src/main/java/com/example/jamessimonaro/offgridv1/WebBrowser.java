package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebBrowser extends AppCompatActivity {


    WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Still working on how to build a web browser
        //setContentView(R.layout.activity_web_browser);

       // wv = (WebView)findViewById(R.id.webView);

        Intent intent = getIntent();


        //This is how you pass data from one page to another
        //String value = intent.getStringExtra("key");      //If it is a string you stored

    }
}
