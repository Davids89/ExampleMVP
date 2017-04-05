package com.example.david.examplemvp.findJoke;

import com.example.david.examplemvp.findJoke.event.MainEvent;

/**
 * Created by david on 3/4/17.
 */

public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void findJoke(String name, String lastName);

    void onMainThread(MainEvent event);

}
