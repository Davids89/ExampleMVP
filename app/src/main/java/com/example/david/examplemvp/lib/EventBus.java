package com.example.david.examplemvp.lib;

/**
 * Created by david on 3/4/17.
 */

public interface EventBus {
    void register(Object suscriber);
    void unregister(Object suscriber);
    void post(Object event);
}
