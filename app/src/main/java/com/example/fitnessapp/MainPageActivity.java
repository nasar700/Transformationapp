package com.example.fitnessapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.WindowManager;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fitnessapp.adapter.RecyclerViewAdapterDays;
import com.example.fitnessapp.adapter.RecyclerViewAdapterHorizImage;
import com.example.fitnessapp.adapter.RecyclerWeekAdapter;
import com.example.fitnessapp.dayone.DayOneActivityList;
import com.example.fitnessapp.fitnessData.APIInterface;
import com.example.fitnessapp.fitnessData.FitnessBannerResponse;
import com.example.fitnessapp.fitnessData.FitnessDataImage;
import com.example.fitnessapp.fitnessData.FitnessDataDays;
import com.example.fitnessapp.fitnessData.FitnessDataWeeks;
import com.example.fitnessapp.fitnessData.WeekResponse;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPageActivity extends AppCompatActivity implements DayClickListener {

    private APIInterface apiInterface;
    private RecyclerView recyclerView,recyclerViewWeek;
    private ArrayList<FitnessDataImage> imageModelArrayList;
    private ArrayList<FitnessDataWeeks> weekModelArrayList;
    private ArrayList<FitnessDataDays> daysModelArrayList;
    private RecyclerViewAdapterHorizImage recyclerViewAdapterHorizImage;
    private RecyclerViewAdapterDays recyclerViewAdapterDays;
    private RecyclerWeekAdapter recyclerWeekAdapter;
    Toolbar toolbar;
    private ProgressDialog nDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        toolbar=(Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        imageModelArrayList=new ArrayList<>();

        recyclerViewAdapterHorizImage = new RecyclerViewAdapterHorizImage(this, imageModelArrayList);
        recyclerView.setAdapter(recyclerViewAdapterHorizImage);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        nDialog = new ProgressDialog(MainPageActivity.this);
        nDialog.setMessage("Loading....");
        nDialog.setTitle("Please Wait.");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();



        //recyclerviewDays = (RecyclerView) findViewById(R.id.recyclerviewDays);
   //     daysModelArrayList = new ArrayList<>();

 //       recyclerViewAdapterDays = new RecyclerViewAdapterDays(this, daysModelArrayList);
//        recyclerviewDays.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
//        recyclerviewDays.setAdapter(recyclerViewAdapterDays);

        recyclerViewWeek = (RecyclerView) findViewById(R.id.recyclerviewDays);
        weekModelArrayList = new ArrayList<>();

        recyclerWeekAdapter = new RecyclerWeekAdapter(this,weekModelArrayList, this);
        recyclerViewWeek.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerViewWeek.setAdapter(recyclerWeekAdapter);


        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


//        recyclerViewWeek.setOnClickListener(new AdapterView<?>().OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Intent intent = new Intent(getApplicationContext(), DayOneActivityList.class);
////                //intent.putExtra("days",daysModelArrayList[i]);
////                startActivity(intent);
////            }
//        });



        fetchFitnessBannerData();
        //fetchFitnessDays();
        fetchFitnessWeeks();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return super.onSupportNavigateUp();
    }



    void fetchFitnessBannerData(){
       //    progress.setVisibility(View.VISIBLE);
        apiInterface = APIClient.getClientFitnessMock().create(APIInterface.class);
       // apiInterface = APIClient.getClientFitnessFireBase().create(APIInterface.class);
        Call<FitnessBannerResponse> call = apiInterface.fitnessBanner();
        call.enqueue(new Callback<FitnessBannerResponse>() {
            @Override
            public void onResponse(Call<FitnessBannerResponse> call, Response<FitnessBannerResponse> response) {
                //    progress.setVisibility(View.GONE);
                Log.d("===Response", response.body().getMeta().getDescription());
                updateBanner(response.body().getData());
                nDialog.dismiss();
            }
            @Override
            public void onFailure(Call<FitnessBannerResponse> call, Throwable t) {
                call.cancel();
                Toast.makeText(MainPageActivity.this, "Something Went Worng.", Toast.LENGTH_LONG).show();
                nDialog.dismiss();
            //          progress.setVisibility(View.GONE);
            }
        });
    }
    private void updateBanner(ArrayList<FitnessDataImage> data){
        imageModelArrayList = data;
        recyclerViewAdapterHorizImage.updateData(data);
        recyclerViewAdapterHorizImage.notifyDataSetChanged();
    }


    void fetchFitnessWeeks(){
        apiInterface = APIClient.getClientFitnessMock().create(APIInterface.class);
        Call<WeekResponse> call = apiInterface.fetchWeek();
        call.enqueue(new Callback<WeekResponse>() {
            @Override
            public void onResponse(Call<WeekResponse> call, Response<WeekResponse> response) {
                Log.d("===response",response.body().getMeta().getDescription());
                updateWeekBanner(response.body().getDataweeks());
                nDialog.dismiss();
            }

            @Override
            public void onFailure(Call<WeekResponse> call, Throwable t) {
                call.cancel();
                Toast.makeText(MainPageActivity.this, "Something Went Worng.", Toast.LENGTH_LONG).show();
                nDialog.dismiss();
            }
        });
    }
    private void updateWeekBanner(ArrayList<FitnessDataWeeks> data){
        weekModelArrayList  = data;
        recyclerWeekAdapter.updateWeek(data);
        recyclerWeekAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDayClick(String id) {
        Log.d("==Day id","=="+id);
        Intent intent = new Intent(getApplicationContext(), DayOneActivityList.class);
        intent.putExtra("days",id);
        startActivity(intent);
    }
}