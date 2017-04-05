package com.example.david.examplemvp.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 3/4/17.
 */

public class Joke {
    @SerializedName("id")
    private String id;
    @SerializedName("joke")
    private String joke;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
