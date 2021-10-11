package com.example.kotlindemo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.kotlindemo.VideoBean
import com.example.kotlindemo.databinding.ActivityLiveDataBinding

class ViewModelActivity : AppCompatActivity() {
    private val TAG = "LiveDataActivity"
    var videoModel: VideoModel = VideoModel.get()
    var count = 0
    lateinit var viewBinding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        videoModel.getVideBean().value = VideoBean("name 1")
        viewBinding.textview.setOnClickListener {
            count++
            videoModel.getVideBean().postValue(VideoBean("name $count"))
        }
        var nameObservable = Observer<String> {
            viewBinding.textview.apply {
                text = it
                Log.d(TAG, "onCreate: " + it)
            }
        }
        videoModel.getVideBean().observe(this) {
            Log.d(TAG, "onCreate: just show " + it)
        }

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        // 不会触发显示
        videoModel.getVideBean().value = VideoBean("我结束了")
    }
}