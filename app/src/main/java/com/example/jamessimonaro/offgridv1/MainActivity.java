package com.example.jamessimonaro.offgridv1;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    ColorMatrix cm = new ColorMatrix();
    cm.setSaturation(0);
    Paint greyscalePaint = new Paint();
    greyscalePaint.setColorFilter(new ColorMatrixColorFilter(cm));
    // Create a hardware layer with the greyscale paint
    v.setLayerType(LAYER_TYPE_HARDWARE, greyscalePaint);

}
