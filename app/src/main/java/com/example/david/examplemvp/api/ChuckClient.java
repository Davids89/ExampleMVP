package com.example.david.examplemvp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 3/4/17.
 */

public class ChuckClient {
    private Retrofit retrofit;
    private static final String BASE_URL = "https://api.icndb.com/";

    public ChuckClient(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ChuckService callToChuck(){
        return this.retrofit.create(ChuckService.class);
    }
}
