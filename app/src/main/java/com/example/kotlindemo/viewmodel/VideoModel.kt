package com.example.kotlindemo.viewmodel;

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlindemo.VideoBean

class VideoModel : ViewModel() {
    private val videoBean: MutableLiveData<VideoBean> by lazy {
        MutableLiveData<VideoBean>().apply {
            value = VideoBean("小欢太感人")
        }
    }

    fun getVideBean(): MutableLiveData<VideoBean> {
        return videoBean
    }

    // 获取singleton
    companion object {
        private lateinit var sInstance: VideoModel

        @MainThread
        fun get(): VideoModel {
            sInstance = if (::sInstance.isInitialized) sInstance else VideoModel()
            return sInstance
        }
    }
}
