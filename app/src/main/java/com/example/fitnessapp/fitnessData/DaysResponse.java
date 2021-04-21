package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DaysResponse {

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("data")
    private ArrayList<FitnessDataDays> dataDays;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<FitnessDataDays> getDataDays() {
        return dataDays;
    }

    public void setDataDays(ArrayList<FitnessDataDays> dataDays) {
        this.dataDays = dataDays;
    }


}
