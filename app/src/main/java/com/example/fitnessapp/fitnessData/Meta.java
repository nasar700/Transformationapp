package com.example.fitnessapp.fitnessData;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("code")
    private String code;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private int status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
