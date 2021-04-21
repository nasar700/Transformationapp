package com.example.fitnessapp.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.DayClickListener;
import com.example.fitnessapp.fitnessData.FitnessDataDays;
import java.util.ArrayList;

public class RecyclerViewAdapterDays extends RecyclerView.Adapter<RecyclerViewAdapterDays.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<FitnessDataDays> daysModelArrayList;
    private DayClickListener dayClickListener;

    public RecyclerViewAdapterDays(Context ctx,ArrayList<FitnessDataDays> daysModelArrayList, DayClickListener dayClickListener){
        inflater= LayoutInflater.from(ctx);
        this.daysModelArrayList = daysModelArrayList;
        this.dayClickListener = dayClickListener;
    }

    public void updateDays(ArrayList<FitnessDataDays> daysModelArrayList){
        this.daysModelArrayList = daysModelArrayList;
    }

    @Override
    public RecyclerViewAdapterDays.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_list_view_workout_days,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDays.ViewHolder holder, int position) {
        final FitnessDataDays fitnessData = daysModelArrayList.get(position);
        final  String title = fitnessData.getDayTitle();
        holder.textView.setText(title);

        holder.row.setOnClickListener(view -> {
            dayClickListener.onDayClick(fitnessData.getDayId());
        });
    }

    @Override
    public int getItemCount()
    {
        return daysModelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout row;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textdays);
            row = (RelativeLayout)itemView.findViewById(R.id.rl_row);
        }
    }
}

//    private ArrayList<FitnessDataDays> daysModelArrayList;
//    LayoutInflater inflater;
//
//    public RecyclerViewAdapterDays(Context applicationContext, ArrayList<FitnessDataDays> daysModelArrayList){
//        this.daysModelArrayList = daysModelArrayList;
//        inflater = (LayoutInflater.from(applicationContext));
//    }
//
//    @Override
//    public int getCount() {
//        return daysModelArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        view=inflater.inflate(R.layout.activity_list_view,null);
//        TextView country=(TextView)view.findViewById(R.id.textView);
//        country.setText(daysModelArrayList.get(i).getDayTitle());
//        return view;
//    }
//
//    public void updateDays(ArrayList<FitnessDataDays> daysModelArrayList){
//        this.daysModelArrayList = daysModelArrayList;
//    }



