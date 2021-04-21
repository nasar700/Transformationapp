package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FitListResponse {
    @SerializedName("meta")
    private Meta meta;

    @SerializedName("data")
    private ArrayList<FitListData> dataFitlist;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<FitListData> getDataFitlist() {
        return dataFitlist;
    }

    public void setDataFitlist(ArrayList<FitListData> dataFitlist) {
        this.dataFitlist = dataFitlist;
    }
}
