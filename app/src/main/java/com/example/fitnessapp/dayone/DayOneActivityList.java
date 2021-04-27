package com.example.fitnessapp.dayone;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.APIClient;
import com.example.fitnessapp.Data;
import com.example.fitnessapp.MainPageActivity;
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
    private ProgressDialog nDialog;
    Toolbar toolbar;
    String id;
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

        nDialog = new ProgressDialog(DayOneActivityList.this);
        nDialog.setMessage("Loading....");
        nDialog.setTitle("Please Wait");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();

        toolbar=(Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("days") ){
            id=(String) extras.getString("days");

        }
//        if (extras != null && extras.containsKey("data") &&
//                extras.getSerializable("data") != null) {
//            fitListData = (FitListData) extras.getSerializable("data");



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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return super.onSupportNavigateUp();
    }



    void fetchFitList(){
        Log.d("==dayss","==msgg"+id);
       //    progress.setVisibility(View.VISIBLE);
     //   apiInterface = APIClient.getClientFitnessMock().create(APIInterface.class);
        apiInterface = APIClient.getClientFitnessFireBase().create(APIInterface.class);
        Call<ArrayList<FitListData>> call = apiInterface.fetchFitList(id);
        call.enqueue(new Callback<ArrayList<FitListData>>() {
            @Override
            public void onResponse(Call<ArrayList<FitListData>> call, Response<ArrayList<FitListData>> response) {
                //    progress.setVisibility(View.GONE);
               // Log.d("===Responsesssss", response.body().getMeta().getDescription());

                updateFitBanner(response.body());
                nDialog.dismiss();
            }
            @Override
            public void onFailure(Call<ArrayList<FitListData>> call, Throwable t) {
                call.cancel();
                Toast.makeText(DayOneActivityList.this, "Something Went Worng.", Toast.LENGTH_LONG).show();
                nDialog.dismiss();
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
