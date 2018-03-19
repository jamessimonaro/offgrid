package com.example.jamessimonaro.offgridv1;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button browse_btn_;
    Button notification_btn_;
    Button greyscale_btn_;
    //TextView textView_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire button to the java code
        browse_btn_=(Button)findViewById(R.id.browse_btn);
        notification_btn_=(Button)findViewById(R.id.browse_btn);
        greyscale_btn_=(Button)findViewById(R.id.browse_btn);

        //How notifications are cleared on-start of application
        //Unforuantly we cannot disable all notifications w/o root access to the phone (according to my research...) - Chris M.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancelAll();


        //textView_ =(TextView)findViewById(R.id.textView);

        //Testing retrieve messages from Web Browser activity
       // Bundle bundle = getIntent().getExtras();
        // String message = getIntent().getStringExtra("message key");
        //textView_.setText(message);


        //On click listener for the browse button
        browse_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  start_browsing();     }});
        notification_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {     }});
        greyscale_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {       }});


    }

        public void start_browsing(){
        Intent myIntent = new Intent(MainActivity.this, WebBrowser.class);
        MainActivity.this.startActivity(myIntent);
        }



}




//HELLO THIS IS A TEST!