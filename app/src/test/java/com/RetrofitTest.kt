package com

import android.app.Activity
import com.example.kotlindemo.ButterKnifeActivity
import okhttp3.*
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException

class RetrofitTest {
    @Test
    fun test() {
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
//        println(responseBody.body()?.string())
    }

    interface GetService {
        @GET("/")
        fun search(): Call<ResponseBody>
    }


    fun okHttpTest() {
        var ok = OkHttpClient().newBuilder()
            .followRedirects(true) // 是否支持重定向
            .build()
        var request = Request.Builder().url("https://baidu.com").build()
        var call = ok.newCall(request)
        var respose = call.execute()
        println(respose.body?.string())
    }

}