package com.example.kotlindemo;

import android.app.Application;
import android.os.Debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.moduth.blockcanary.BlockCanary;

public class BlockCanaryApplication extends Application {
    public static final String DEBUG = "debug";


    @Override
    public void onCreate() {
        super.onCreate();
        Debug.startMethodTracing("/sdcard/debug.trace");
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
