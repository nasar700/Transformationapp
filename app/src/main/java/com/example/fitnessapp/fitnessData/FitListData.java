package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FitListData implements Serializable {

    @SerializedName("worklist")
    private String worklist;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("imageIcon")
    private String imageIcon;

    @SerializedName("gif")
    private String gif;

    @SerializedName("workTimes")
    private String workTimes;

    @SerializedName("durationtime")
    private long durationtime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public String getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(String workTimes) {
        this.workTimes = workTimes;
    }

    public long getDurationtime() {
        return durationtime;
    }

    public void setDurationtime(long durationtime) {
        this.durationtime = durationtime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWorklist() {
        return worklist;
    }

    public void setWorklist(String worklist) {
        this.worklist = worklist;
    }
}
