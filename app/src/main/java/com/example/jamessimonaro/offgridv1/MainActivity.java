package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button browse_btn_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire button to the java code
        browse_btn_=(Button)findViewById(R.id.browse_btn);

        //On click listener for the browse button
        browse_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  start_browsing();     }});
    }

        public void start_browsing(){
        Intent myIntent = new Intent(MainActivity.this, WebBrowser.class);
        MainActivity.this.startActivity(myIntent);
        }

}




//HELLO THIS IS A TEST!