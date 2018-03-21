package com.example.jamessimonaro.offgridv1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize GUI components
    Button browse_btn_;
    Button todolist_btn_;
    ImageView greyscale_img_;
    TextView greyscale_txt_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire button to the java code
        browse_btn_=(Button)findViewById(R.id.browse_btn);
        todolist_btn_=(Button)findViewById(R.id.todolist_btn);
        greyscale_img_=(ImageView) findViewById(R.id.grayscale_img);
        greyscale_txt_=(TextView)findViewById(R.id.greyscale_txt);


        //On click listener for the browse button
        browse_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  start_browsing();     }});
        todolist_btn_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  todo_list();     }});
        greyscale_img_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {   greyscale();    }});
        greyscale_txt_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {                    }});
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

    public void greyscale(){
        //This method will change the button color from rainbow to black and white

        Boolean color = true;

        if(color==true) {
            color = false;
            greyscale_txt_.setText("Grey Scale");
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            greyscale_img_.setColorFilter(filter);

        }
        else{
            //For some reason this boolean isn't working???
            color = true;
            greyscale_txt_.setText("Full Color");
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(100);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            greyscale_img_.setColorFilter(filter);
        }
    }

}




//HELLO THIS IS A TEST!