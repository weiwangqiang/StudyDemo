package com.example.daggerdemo.di

import com.example.daggerdemo.MainActivity
import com.example.daggerdemo.SecondActivity
import com.example.daggerdemo.base.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [DataModule::class])
    abstract fun tasksActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [DataModule::class])
    abstract fun tasksSecondActivity(): SecondActivity

}