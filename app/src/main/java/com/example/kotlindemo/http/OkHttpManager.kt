package com.example.kotlindemo.http

import android.app.AlertDialog
import okhttp3.*
import java.io.IOException;

// okHttp demo
class OkHttpManager {

    val myInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(chain.request())
        }
    }

    val cookieJar = object : CookieJar {
        override fun loadForRequest(url: HttpUrl): List<Cookie> {
            TODO("Not yet implemented")
        }

        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            TODO("Not yet implemented")
        }

    }

    val eventListener = object : EventListener() {

    }

    init {
        var ok = OkHttpClient().newBuilder()
            .followRedirects(true) // 是否支持重定向
            .addInterceptor(myInterceptor) //  添加应用拦截器，在最前面
            .addNetworkInterceptor(myInterceptor) // 网络拦截器，在connect拦截器与CallServer拦截器之间
            .cookieJar(cookieJar) // 设置cookie缓存机制，默认是不做cookie缓存的
            .eventListener(eventListener) // 设置请求的监听，包含NDS，请求回调，缓存命中，代理等
            .build()

        var request = Request.Builder().url("").build()
        ok.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
            }
        })
        ok.newCall(request).execute()
    }

    fun test(){
        AlertDialog.Builder(null)
    }

}
