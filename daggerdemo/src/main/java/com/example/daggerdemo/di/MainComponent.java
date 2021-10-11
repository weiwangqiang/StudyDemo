package com.example.daggerdemo.di;


import android.app.Application;

import com.example.daggerdemo.DataRepository;
import com.example.daggerdemo.MainApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        AndroidInjectionModule.class})
public interface MainComponent extends AndroidInjector<MainApplication> {
    DataRepository getDataRepository();

    @Component.Builder
    interface Builder {

        @BindsInstance
        MainComponent.Builder application(Application application);

        MainComponent build();
    }
}
