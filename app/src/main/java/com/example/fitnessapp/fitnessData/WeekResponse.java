package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeekResponse {
    @SerializedName("meta")
    private Meta meta;

    @SerializedName("data")
    private ArrayList<FitnessDataWeeks> dataweeks;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<FitnessDataWeeks> getDataweeks() {
        return dataweeks;
    }

    public void setDataweeks(ArrayList<FitnessDataWeeks> dataweeks) {
        this.dataweeks = dataweeks;
    }
}
