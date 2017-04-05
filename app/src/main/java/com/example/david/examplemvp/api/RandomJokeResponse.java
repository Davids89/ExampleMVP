package com.example.david.examplemvp.api;

import com.example.david.examplemvp.entities.Joke;
import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 3/4/17.
 */

public class RandomJokeResponse {
    @SerializedName("type")
    private String type;
    @SerializedName("value")
    private Joke joke;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
