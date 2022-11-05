package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SecondActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        StockLiveData.get().observe(this, {
            Log.d(TAG, "onCreate: $it")
        })
    }
}