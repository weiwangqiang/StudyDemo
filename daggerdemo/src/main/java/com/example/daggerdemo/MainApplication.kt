package com.example.daggerdemo

import androidx.annotation.VisibleForTesting
import com.example.daggerdemo.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent.builder().application(this).build()
    }
}