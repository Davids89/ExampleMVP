package com.example.david.examplemvp.findJoke;


import com.example.david.examplemvp.api.ChuckClient;
import com.example.david.examplemvp.api.RandomJokeResponse;
import com.example.david.examplemvp.entities.Joke;
import com.example.david.examplemvp.findJoke.event.MainEvent;
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
    public void findJoke(String name, String lastName) {

        if(name.length() == 0 || lastName.length() == 0){
            name = null;
            lastName = null;
        }

        client.callToChuck().getRandomWithName(name, lastName).enqueue(new Callback<RandomJokeResponse>() {
            @Override
            public void onResponse(Call<RandomJokeResponse> call, Response<RandomJokeResponse> response) {
                if(response.code() == 200){
                    success(response.body().getJoke());
                }else{
                    error();
                }
            }

            @Override
            public void onFailure(Call<RandomJokeResponse> call, Throwable t) {
                error();
            }
        });
    }

    private void success(Joke joke){
        post(joke, false);
    }

    private void error(){
        post(null, true);
    }

    private void post(Joke joke, boolean error){

        MainEvent event = new MainEvent();

        if(!error){
            event.setType(MainEvent.onSuccess);
            event.setJoke(joke);
        }else{
            event.setType(MainEvent.onError);
        }

        eventBus.post(event);

    }
}
