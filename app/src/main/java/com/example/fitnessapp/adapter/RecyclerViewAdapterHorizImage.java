package com.example.fitnessapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitnessapp.R;
import com.example.fitnessapp.fitnessData.FitnessDataImage;


import java.util.ArrayList;

public class RecyclerViewAdapterHorizImage extends RecyclerView.Adapter<RecyclerViewAdapterHorizImage.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<FitnessDataImage> imageModelArrayList;

//
    public RecyclerViewAdapterHorizImage(Context ctx, ArrayList<FitnessDataImage> imageModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

//
    public void updateData(ArrayList<FitnessDataImage> imageModelArrayList){
        this.imageModelArrayList = imageModelArrayList;
    }




    @Override
    public RecyclerViewAdapterHorizImage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout_itemlist,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterHorizImage.ViewHolder holder, int position) {
        //holder.image.setImageResource(imageModelArrayList.get(position).getImage_drawable());
   //     Log.d("===banner id", ""+imageModelArrayList.get(position).getId());

        final String url =imageModelArrayList.get(position).getImageUrl();
        Glide.with(holder.image.getContext())
            .load(url)
            .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.iv);
        }
    }
}

