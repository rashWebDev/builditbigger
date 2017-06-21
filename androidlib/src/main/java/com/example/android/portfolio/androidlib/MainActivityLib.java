package com.example.android.portfolio.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityLib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);

        Intent intent = getIntent();
        String javalib = intent.getStringExtra("gcelib");
        TextView textView = (TextView)findViewById(R.id.display);
        textView.setText(javalib);
    }
}
