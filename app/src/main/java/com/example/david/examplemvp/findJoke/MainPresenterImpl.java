package com.example.david.examplemvp.findJoke;

import com.example.david.examplemvp.findJoke.event.MainEvent;
import com.example.david.examplemvp.lib.EventBus;
import com.example.david.examplemvp.lib.GreenRobotEventBus;
import com.example.david.examplemvp.findJoke.ui.MainView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by david on 3/4/17.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainRepository repository;
    private MainView view;
    private EventBus eventBus;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        this.repository = new MainRepositoryImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        if(view != null){
            eventBus.register(this);
        }
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void findJoke() {
        repository.findJoke();
    }

    @Override
    @Subscribe
    public void onMainThread(MainEvent event) {

    }
}
