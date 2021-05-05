package com.example.fitnessapp.frontpagesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class ActivityBoys extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boys);
        toolbar=(Toolbar) findViewById(R.id.tool_bar);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return super.onSupportNavigateUp();
    }
}