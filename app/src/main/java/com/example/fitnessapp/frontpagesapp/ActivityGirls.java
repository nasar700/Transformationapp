package com.example.fitnessapp.frontpagesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessapp.R;

public class ActivityGirls extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar=(Toolbar) findViewById(R.id.tool_bar);
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