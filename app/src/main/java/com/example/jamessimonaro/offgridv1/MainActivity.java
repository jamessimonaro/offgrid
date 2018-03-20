package com.example.jamessimonaro.offgridv1;

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

    //Initialize GUI components
    Button browse_btn_;
    Button todolist_btn_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire button to the java code
        browse_btn_=(Button)findViewById(R.id.browse_btn);
        todolist_btn_=(Button)findViewById(R.id.todolist_btn);


        //On click listener for the browse button
        browse_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  start_browsing();     }});
        todolist_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  todo_list();     }});


    }

        public void start_browsing(){
        //This method will open a browser within the app
        Intent myIntent = new Intent(MainActivity.this, WebBrowser.class);
        MainActivity.this.startActivity(myIntent);
        }

    public void todo_list(){
        //This method will open a browser within the app
        Intent mylist = new Intent(MainActivity.this, todolist.class);
        MainActivity.this.startActivity(mylist);
    }

}




//HELLO THIS IS A TEST!