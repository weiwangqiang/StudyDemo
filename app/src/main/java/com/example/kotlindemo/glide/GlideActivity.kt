package com.example.kotlindemo.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import okhttp3.*
import java.io.File
import java.io.IOException

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
//        Glide.with(this).asDrawable().load("").diskCacheStrategy().into(null)
        okHttpDemo()
    }

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

    private fun okHttpDemo() {
        //缓存文件夹
        //缓存文件夹
        val cacheFile = File(externalCacheDir.toString(), "cache")
//缓存大小为10M
//缓存大小为10M
        val cacheSize = 10 * 1024 * 1024
//创建缓存对象
//创建缓存对象
        val cache = Cache(cacheFile, cacheSize.toLong())
        var ok = OkHttpClient().newBuilder()
            .followRedirects(true) // 是否支持重定向
            .addInterceptor(myInterceptor) //  添加应用拦截器，在最前面
            .addNetworkInterceptor(myInterceptor) // 网络拦截器，在connect拦截器与CallServer拦截器之间
            .cookieJar(cookieJar) // 设置cookie缓存机制，默认是不做cookie缓存的
            .cache(cache)
            .eventListener(eventListener) // 设置请求的监听，包含NDS，请求回调，缓存命中，代理等
            .build()

        val request = Request.Builder().url("").build()
        ok.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
            }
        })
        ok.newCall(request).execute()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}