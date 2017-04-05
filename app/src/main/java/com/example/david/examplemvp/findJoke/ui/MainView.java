package com.example.david.examplemvp.findJoke.ui;

import com.example.david.examplemvp.entities.Joke;

/**
 * Created by david on 3/4/17.
 */

public interface MainView {
    void jokeSuccess(Joke joke);

    void jokeError();
}
