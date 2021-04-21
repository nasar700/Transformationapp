package com.example.fitnessapp.fitnessData;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class FitnessBannerResponse {
    @SerializedName("meta")
    private Meta meta;

    @SerializedName("data")
    private ArrayList<FitnessDataImage> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<FitnessDataImage> getData() {
        return data;
    }

    public void setData(ArrayList<FitnessDataImage> data) {
        this.data = data;
    }
}
