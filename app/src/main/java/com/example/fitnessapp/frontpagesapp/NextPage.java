package com.example.fitnessapp.frontpagesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.MainPageActivity;
import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.APIInterface;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class NextPage extends AppCompatActivity {
    private APIInterface apiInterface;
    private AdView adView;
    AdRequest adRequest;
    Button b1,b2;
    TextView t1;
    @Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page);

        adView=(AdView) findViewById(R.id.ad_view);
        adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        b1=(Button)findViewById(R.id.button_boys);
        b2=(Button)findViewById(R.id.button_girls);
        t1=(TextView)findViewById(R.id.textView_skip);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), ActivityBoys.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityGirls.class);
                startActivity(i);
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);

            }
        });

    }




    @Override
    public void onPause(){
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }


}
