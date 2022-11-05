package com.example.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class VideoViewModel extends BaseObservable {
    private VideoBean videoBean = new VideoBean("小黄人", "http://xiaohuangren.com");

    @Bindable
    public VideoBean getVideoBean() {
        return videoBean;
    }

    public void setVideoBean(VideoBean videoBean) {
        this.videoBean = videoBean;
        notifyPropertyChanged(BR.video);
    }
}
