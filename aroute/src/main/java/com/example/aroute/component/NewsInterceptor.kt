package com.example.aroute.component

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

private const val TAG = "NewsInterceptor"

@Interceptor(priority = 1, name = "新闻拦截")
class NewsInterceptor : IInterceptor {

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.d(TAG, "init: ")
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        Log.d(TAG, "process: ${postcard}")
//        callback?.onContinue(postcard)
        callback?.onInterrupt(RuntimeException("我觉得有点异常"));  // 觉得有问题，中断路由流程
    }
}