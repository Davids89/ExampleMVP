package com.example.david.examplemvp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by david on 3/4/17.
 */

public interface ChuckService {
    @GET("jokes/random")
    Call<RandomJokeResponse> getRandom(@Query("firstName") String firstName,
                                       @Query("lastName") String lastName);
}
