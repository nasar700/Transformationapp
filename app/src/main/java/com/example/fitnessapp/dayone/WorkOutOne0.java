package com.example.fitnessapp.dayone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
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
    TextView textView, skip, mtitle, mtimes, mduration, mshow_duration,textView_countdown;
    ImageView mimageView;
    FitListData fitListData;
    //    private Data data;
    private int position;
    private CountDownTimer countDownTimer;
     MediaPlayer count_down,peep,play_sound;
     private boolean isFinish;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_one);

        button = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.count_textview);
        textView_countdown=(TextView) findViewById(R.id.countdown_textview);
        mtitle = (TextView) findViewById(R.id.tv_title);
        mtimes = (TextView) findViewById(R.id.tv_times);
        mshow_duration = (TextView) findViewById(R.id.tv_show_duration);
        mimageView = findViewById(R.id.img_icon);

        mduration = (TextView) findViewById(R.id.count_textview);

        skip = findViewById(R.id.work_out_skip);
        onCLickButton();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView_countdown.setVisibility(View.GONE);



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
                count_down.stop();
                peep.stop();
                play_sound.stop();
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
        mshow_duration.setText("Duration "+TimeUnit.MILLISECONDS.toSeconds(data.getDurationtime())+" Sec");
        showImage(false);

        textView.setText(""+TimeUnit.MILLISECONDS.toSeconds(data.getDurationtime()));
        if(countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }

    }
    private void showImage(boolean isShowGif){
        if (isShowGif){
            Glide.with(getApplicationContext())
                    .asGif()
                    .load(fitListData.getGif())
                    .into(mimageView);
        }else {
            Glide.with(this)
                    .load(fitListData.getImageUrl())
                    .into(mimageView);
        }
    }

    public void onCLickButton() {
        count_down = MediaPlayer.create(this,R.raw.count_down);
        peep=MediaPlayer.create(this,R.raw.beep_04);
        play_sound=MediaPlayer.create(this,R.raw.play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  WorkOutOne0.this.onClick();
                count_down.start();
                button.setEnabled(false);


            }
        });

    }
    //
    @Override
    protected void onStop() {
        super.onStop();
        if(play_sound!=null && play_sound.isPlaying())
        {
            play_sound.stop();
            play_sound.release();
            play_sound = null;

        }
         if (count_down!=null && count_down.isPlaying()){
            count_down.stop();
            count_down.release();
            count_down = null;
        }
        if (peep!=null && peep.isPlaying()){
            peep.stop();
            peep.release();
            peep = null;
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(play_sound!=null && play_sound.isPlaying())
        {
            play_sound.stop();
            play_sound.release();
            play_sound = null;

        } if (count_down!=null && count_down.isPlaying()){
            count_down.stop();
            count_down.release();
            count_down = null;
        }
        if (peep!=null && peep.isPlaying()){
            peep.stop();
            peep.release();
            peep = null;
        }

        isFinish=true;
        if (countDownTimer!=null)
            countDownTimer.onFinish();


    }
   ;
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

        countClick();

     }
     private void onStarts(){
        showImage(true);

         countDownTimer = new CountDownTimer(fitListData.getDurationtime(),1000){
             public void onTick(long millisUntilFinished){
                 textView.setText("0:"+TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
                 counter--;
                 if (play_sound!=null) {
                     play_sound.start();
                 }
             }

             public  void onFinish(){
                 textView.setText("THANK YOU!");
                 if (play_sound!=null){
                     play_sound.stop();
                 }
                 if (peep!=null) {
                     peep.start();
                 }
                 if (!isFinish) {
                     showImage(false);
                 }
             }
         }.start();



     }
    private void countClick(){
        textView_countdown.setVisibility(View.VISIBLE);
        countDownTimer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long l) {
                textView_countdown.setText(""+TimeUnit.MILLISECONDS.toSeconds(l));
                counter--;
            }

            @Override
            public void onFinish() {
                peep.stop();
                textView_countdown.setVisibility(View.INVISIBLE);
                if (!isFinish)
                    onStarts();
            }
        }.start();
    }

}