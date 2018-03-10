package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_web_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_web_=(Button)findViewById(R.id.button_web);
        button_web_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {     start_web();        }});

    }

    public void start_web(){
        Intent webBrowser = new Intent(MainActivity.this, web.class);
        MainActivity.this.startActivity(webBrowser);

    }


}
