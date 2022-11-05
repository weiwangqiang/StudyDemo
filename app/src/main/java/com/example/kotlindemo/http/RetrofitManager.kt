package com.example.kotlindemo.http

import okhttp3.ResponseBody
import retrofit2.Call
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
        var responseBody = call.execute()
        println(responseBody.code())
        println(responseBody.message().toString())
    }

    interface GetService {
        @GET("/")
        fun search(): Call<ResponseBody>
    }

}