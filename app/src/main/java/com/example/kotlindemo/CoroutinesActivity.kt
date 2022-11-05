package com.example.kotlindemo

import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import okhttp3.internal.wait

class CoroutinesActivity : AppCompatActivity() {

    private val TAG = "CoroutinesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        GlobalScope.launch {
            Log.d(
                TAG,
                "onCreate: launch ${Thread.currentThread().name} is main Looper ${Looper.myLooper() == Looper.getMainLooper()}"
            )
            Thread.sleep(100000)
        }
        Log.d(TAG, "onCreate: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
}