package com.example.fitnessapp.dayone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.APIClient;
import com.example.fitnessapp.Data;
import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.APIInterface;
import com.example.fitnessapp.fitnessData.FitListData;
import com.example.fitnessapp.fitnessData.FitListResponse;
import com.example.fitnessapp.fitnessData.FitnessBannerResponse;
import com.example.fitnessapp.fitnessData.FitnessDataImage;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DayOneActivityList extends AppCompatActivity {
   // private ProgressBar progress;
    private APIInterface apiInterface;
    private CustomAdapterOne customAdapterOne;
    private ArrayList<FitListData> fitListModelArrayList;
    ListView listData;
  //  ImageView imageView;

   // String fitList[] = {"THY", "LEG", "CHEST", "ABS", "HAND"};
   // private ArrayList<Data>  dataList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_list);

        fitListModelArrayList = new ArrayList<>();
        listData=(ListView) findViewById(R.id.listView_work_one);
        customAdapterOne = new CustomAdapterOne(this,fitListModelArrayList);
        listData.setAdapter(customAdapterOne);



        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), WorkOutOne0.class);

                intent.putExtra("data", fitListModelArrayList.get(i));

                startActivity(intent);
            }
        });
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fetchFitList();
    }

    void fetchFitList(){
       //    progress.setVisibility(View.VISIBLE);
        apiInterface = APIClient.getClientFitnessMock().create(APIInterface.class);
        Call<FitListResponse> call = apiInterface.fetchFitList();
        call.enqueue(new Callback<FitListResponse>() {
            @Override
            public void onResponse(Call<FitListResponse> call, Response<FitListResponse> response) {
                //    progress.setVisibility(View.GONE);
                Log.d("===Responsesssss", response.body().getMeta().getDescription());
                updateFitBanner(response.body().getDataFitlist());
            }
            @Override
            public void onFailure(Call<FitListResponse> call, Throwable t) {
                call.cancel();
                //      progress.setVisibility(View.GONE);
            }
        });
    }
    private void updateFitBanner(ArrayList<FitListData> data){
        fitListModelArrayList = data;
        customAdapterOne.updateData(data);
        customAdapterOne.notifyDataSetChanged();

    }

}
