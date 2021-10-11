package com.example.kotlindemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 监听的回调
 */
public class LifeCycleListener implements LifecycleObserver {

    private Lifecycle lifecycle;

    public LifeCycleListener(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    private static final String TAG = "LifeCycleListener";

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d(TAG, "onResume: " + (lifecycle.getCurrentState() == Lifecycle.State.RESUMED));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.d(TAG, "onStop: " + (lifecycle.getCurrentState() == Lifecycle.State.RESUMED));
    }
}
