package com.example.aroute

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 如果功能没有生效，就直接打开debug模式
        ARouter.openDebug()
        ARouter.openLog()
        ARouter.init(this)
    }
}