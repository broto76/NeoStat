package com.broto.neostat.datahandler;

import com.broto.neostat.models.NasaResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RetrofitService {
    @GET("neo/rest/v1/feed")
    public Call<NasaResponseModel> getAsteroidDetails(
            @Query("start_date") String start_date,
            @Query("end_date") String end_date,
            @Query("api_key") String api_key
    );
}
