package com.example.kotlindemo.http

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RetrofitManager {

    fun get() {
        var getService = Retrofit
            .Builder()
            .baseUrl("https://baidu.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetService::class.java)
        var call = getService.search();
        // 同步调用
        var responseBody = call.execute()
        println(responseBody.code())
        println(responseBody.message().toString())
        // 异步调用
        call.enqueue(object : Callback<Task> {
            override fun onResponse(call: Call<Task>, response: Response<Task>) {
                // 主线程
            }

            override fun onFailure(call: Call<Task>, t: Throwable) {
            }
        })
    }

    interface GetService {
        @GET("/")
        fun search(): Call<Task>
    }

    inner class Task {

    }
}