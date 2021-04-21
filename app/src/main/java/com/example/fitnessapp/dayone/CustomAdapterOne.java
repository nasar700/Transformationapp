package com.example.fitnessapp.dayone;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.FitListData;

import java.util.ArrayList;

public class CustomAdapterOne extends BaseAdapter {

  //  Context context;
    private ArrayList<FitListData> fitListModelArrayList;
    private  LayoutInflater inflater;

    public CustomAdapterOne(Context ctx,ArrayList<FitListData> fitListModelArrayList){
        inflater = (LayoutInflater.from(ctx));
        this.fitListModelArrayList=fitListModelArrayList;
    }

    public void updateData(ArrayList<FitListData> fitListModelArrayList){
        this.fitListModelArrayList =fitListModelArrayList;
    }

    @Override
    public int getCount() {
        return fitListModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return fitListModelArrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final String url  = fitListModelArrayList.get(i).getImageUrl();

        // get current item to be displayed
        FitListData data = (FitListData) getItem(i);
        view = inflater.inflate(R.layout.activity_list_view_workout,viewGroup,false);

        // get the TextView for item name
        TextView txt=(TextView) view.findViewById(R.id.text_workout);
        ImageView img = (ImageView) view.findViewById(R.id.img_workout);
        txt.setText(data.getWorklist());
        Glide.with(view.getContext())
                .load(url)
                .into(img);
        return view;
    }
}
