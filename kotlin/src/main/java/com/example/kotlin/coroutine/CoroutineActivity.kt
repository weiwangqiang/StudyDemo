package com.example.kotlin.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlin.R
import kotlinx.coroutines.*

private const val TAG = "CoroutineActivity"

class CoroutineActivity : AppCompatActivity() {
    val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
    }

    fun button(view: View) {
        scope.launch {
            delay(1000)
            Log.d(TAG, "button: ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                Log.d(TAG, "button: withContext ${Thread.currentThread().name}")
            }
        }
        Log.d(TAG, "button:  finish ")
    }
}