package com.example.daggerdemo.di

import com.example.daggerdemo.base.MainPresenter
import com.example.daggerdemo.base.ActivityScoped
import com.example.daggerdemo.base.MainContract
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @ActivityScoped
    @Binds
    abstract fun mainPresenter(presenter: MainPresenter): MainContract.IPresenter
}