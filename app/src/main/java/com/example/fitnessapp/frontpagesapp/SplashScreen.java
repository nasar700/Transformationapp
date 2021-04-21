package com.example.fitnessapp.frontpagesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.APIInterface;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, NextPage.class));
                finish();
            }
        },1000);

    //    fetchSplashBanner();

//        ImageView img = (ImageView) findViewById(R.id.imgplash);
//        Animation aniSlide =  AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
//        img.startAnimation(aniSlide);
    }



//    void fetchSplashBanner(){
//        //   progress.setVisibility(View.VISIBLE);
//        apiInterface = APIClient.getClientFitnessMock().create(APIInterface.class);
//        Call<SplashResponse> call = apiInterface.fetchSplash();
//        call.enqueue(new Callback<SplashResponse>() {
//            @Override
//            public void onResponse(Call<SplashResponse> call, Response<SplashResponse> response) {
//                //    progress.setVisibility(View.GONE);
//                Log.d("===Response", response.body().getMeta().getDescription());
//     //           updateBanner(response.body().getData());
//            }
//            @Override
//            public void onFailure(Call<SplashResponse> call, Throwable t) {
//                call.cancel();
//                //      progress.setVisibility(View.GONE);
//            }
//        });
//    }

}
