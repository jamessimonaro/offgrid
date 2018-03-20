package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.EGLConfig;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import javax.microedition.khronos.opengles.GL10;

import static android.graphics.Color.GRAY;

public class WebBrowser extends AppCompatActivity {

    //Initialize Webview
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
       wv.loadUrl("http://www.darkskywest.com/index.htm");
    }


}
