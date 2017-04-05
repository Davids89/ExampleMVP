package com.example.david.examplemvp.findJoke;

import android.util.Log;

import com.example.david.examplemvp.api.ChuckClient;
import com.example.david.examplemvp.api.RandomJokeResponse;
import com.example.david.examplemvp.lib.EventBus;
import com.example.david.examplemvp.lib.GreenRobotEventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by david on 3/4/17.
 */

public class MainRepositoryImpl implements MainRepository {

    private ChuckClient client;
    private EventBus eventBus;

    public MainRepositoryImpl() {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.client = new ChuckClient();
    }

    @Override
    public void findJoke() {
        client.callToChuck().getRandom("david", "luque").enqueue(new Callback<RandomJokeResponse>() {
            @Override
            public void onResponse(Call<RandomJokeResponse> call, Response<RandomJokeResponse> response) {
                Log.d("REPOSITORY", response.body().toString());
            }

            @Override
            public void onFailure(Call<RandomJokeResponse> call, Throwable t) {

            }
        });
    }
}
