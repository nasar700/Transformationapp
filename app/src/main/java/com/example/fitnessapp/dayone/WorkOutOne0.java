package com.example.fitnessapp.dayone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.FitListData;

import java.util.concurrent.TimeUnit;

public class WorkOutOne0 extends AppCompatActivity {
    public long counter;
    Button button;
    TextView textView, skip, mtitle, mtimes, mduration, mshow_duration;
    ImageView mimageView;
    FitListData fitListData;
    //    private Data data;
    private int position;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_one);

        button = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.count_textview);
        mtitle = (TextView) findViewById(R.id.tv_title);
        mtimes = (TextView) findViewById(R.id.tv_times);
        mshow_duration = (TextView) findViewById(R.id.tv_show_duration);
        mimageView = findViewById(R.id.img_icon);

        mduration = (TextView) findViewById(R.id.count_textview);

        skip = findViewById(R.id.work_out_skip);
        onCLickButton();

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("data") &&
                extras.getSerializable("data") != null) {
            fitListData = (FitListData) extras.getSerializable("data");
            updateViews(fitListData);
//            position = extras.getInt("selected_position");
//
//            if(dataArrayList !=null){
//                updateViews(dataArrayList.get(position));
//
//            }
        }
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                button.setEnabled(true);
//                if(position == dataArrayList.size()-1){
//                    finish();
//                }else{
//                    position = position + 1;
//                    updateViews(dataArrayList.get(position));
//                }
            }
        });

    }

    private void updateViews(FitListData data) {
        mtitle.setText(data.getWorklist());
        mtimes.setText(data.getWorkTimes());
        mshow_duration.setText("Duration "+TimeUnit.MILLISECONDS.toSeconds(data.getDurationtime())+" secs");
        Glide.with(this)
                .load(data.getImageUrl())
                .into(mimageView);

        textView.setText("Remaining \n"+TimeUnit.MILLISECONDS.toSeconds(data.getDurationtime()));
        if(countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }

    }
    public void onCLickButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  WorkOutOne0.this.onClick();
                button.setEnabled(false);

            }
        });

    }
    //


//        Glide.with(this)
//                    .load("https://i.pinimg.com/originals/74/7e/47/747e47f06c6fd6f99b303ba33a1aaabd.gif")
//                    .apply(
//                        new RequestOptions()
//                            .placeholder(R.drawable.btn_logo)
//                            .error(R.drawable.btn_logo)
//                            .centerCrop()
//                            .fitCenter()
//                    )
//                    .into(
//                        imageView
//                    );


    private void onClick() {
        Glide.with(this)
                .asGif()
                 .load(fitListData.getGif())
                .into(mimageView);

        countDownTimer = new CountDownTimer(fitListData.getDurationtime(),1000){
            public void onTick(long millisUntilFinished){
                textView.setText("remaining \n"+TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
                counter--;
            }

            public  void onFinish(){
                textView.setText("THANK YOU !!");
            }
        }.start();

     }
}