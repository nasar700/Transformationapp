package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

public class FitnessDataDays {

    @SerializedName("dayTitle")
    private String dayTitle;

    @SerializedName("dayId")
    private String dayId;

    public String getDayTitle() {
        return dayTitle;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }
}
