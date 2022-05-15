package com.example.aroute.provider

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.aroute.Constant
import com.example.aroute.bean.NewsBean

@Route(path = Constant.PROVIDER_NEWS)
class NewsProvider : IProvider {
    override fun init(context: Context?) {

    }

    fun getNews(): NewsBean {
        return NewsBean("新闻");
    }
}