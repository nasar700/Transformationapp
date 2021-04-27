package com.example.fitnessapp.fitnessData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("getImageList")
    Call<ArrayList<String>> fetchImageList();

    @GET("fitnessbanner")
    Call<FitnessBannerResponse> fitnessBanner();

    @GET("fitnessdays")
    Call<DaysResponse> fetchDays();

    @GET("fitnessweek")
    Call<WeekResponse> fetchWeek();

//    @GET("fitnessworklist1")
//    Call<FitListResponse> fetchFitList();

    @GET("{dayId}.json")
    Call<ArrayList<FitListData>> fetchFitList(@Path("dayId") String id);

}
