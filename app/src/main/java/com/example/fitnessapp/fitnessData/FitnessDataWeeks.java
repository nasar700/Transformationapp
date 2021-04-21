package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FitnessDataWeeks {

    @SerializedName("weekTitle")
    private String weekTitle;

    @SerializedName("dayList")
    private ArrayList<FitnessDataDays> dayList;

    public ArrayList<FitnessDataDays> getDayList() {
        return dayList;
    }

    public void setDayList(ArrayList<FitnessDataDays> dayList) {
        this.dayList = dayList;
    }

    public String getWeekTitle() {
        return weekTitle;
    }



    public void setWeekTitle(String weekTitle) {
        this.weekTitle = weekTitle;
    }
}
