package com.example.david.examplemvp.findJoke.event;

import com.example.david.examplemvp.entities.Joke;

/**
 * Created by david on 3/4/17.
 */

public class MainEvent {
    public final static int onSuccess = 0;
    public final static int onError = 1;

    private int type;
    private Joke joke;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
