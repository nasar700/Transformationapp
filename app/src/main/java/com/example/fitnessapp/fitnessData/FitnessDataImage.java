package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

public class FitnessDataImage {
    @SerializedName("id")
    private int id;

    @SerializedName("imageUrl")
    private String imageUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
