package com.example.fitnessapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.DayClickListener;
import com.example.fitnessapp.fitnessData.FitnessDataDays;
import com.example.fitnessapp.fitnessData.FitnessDataWeeks;

import java.util.ArrayList;

public class RecyclerWeekAdapter extends RecyclerView.Adapter<RecyclerWeekAdapter.ViewHolder> {
    private LayoutInflater inflater;

    private ArrayList<FitnessDataWeeks> weeksModelArrayList;
    private ArrayList<FitnessDataDays> daysModelArrayList;
    private  RecyclerViewAdapterDays recyclerViewAdapterDays;

    public RecyclerWeekAdapter(Context ctx, ArrayList<FitnessDataWeeks> weeksModelArrayList, DayClickListener dayClickListener){
        inflater = LayoutInflater.from(ctx);
        this.weeksModelArrayList = weeksModelArrayList;
        recyclerViewAdapterDays = new RecyclerViewAdapterDays(ctx,daysModelArrayList, dayClickListener);

    }
    public void updateWeek(ArrayList<FitnessDataWeeks> weeksModelArrayList){
        this.weeksModelArrayList = weeksModelArrayList;

    }


    @Override
    public RecyclerWeekAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_week,parent,false);
        RecyclerWeekAdapter.ViewHolder holder= new RecyclerWeekAdapter.ViewHolder(view);
        return holder;
    }
//
    @Override
    public void onBindViewHolder(RecyclerWeekAdapter.ViewHolder holder, int position) {
            final String title = weeksModelArrayList.get(position).getWeekTitle();
            holder.textView1.setText(title);
            recyclerViewAdapterDays.updateDays(weeksModelArrayList.get(position).getDayList());
    }


    @Override
    public int getItemCount()
    {
        return weeksModelArrayList.size();
    }

//
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView_week);
            recyclerView= (RecyclerView)itemView.findViewById(R.id.recyclerViewWeek);
            recyclerView.setLayoutManager(new LinearLayoutManager(textView1.getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(recyclerViewAdapterDays);

        }
    }
}
