package com.example.livedata

import android.util.Log
import androidx.lifecycle.MutableLiveData

class StockLiveData : MutableLiveData<String>() {
    companion object {
        private const val TAG = "StockLiveData"

        // 声明一个单例
        private lateinit var instance: StockLiveData
        fun get(): StockLiveData {
            instance = if (::instance.isInitialized) instance else StockLiveData()
            return instance
        }
    }

    override fun onActive() {
        super.onActive()
        Log.d(TAG, "onActive: ")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d(TAG, "onInactive: ")
    }
}