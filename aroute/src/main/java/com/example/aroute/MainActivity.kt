package com.example.aroute

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.example.aroute.bean.NewsBean
import com.example.aroute.databinding.ActivityMainBinding
import com.example.aroute.provider.NewsProvider

/**
 *
 */
private const val TAG = "MainActivity"

@Route(path = Constant.MAIN_ACTIVITY)
class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    // 通过注入方式获取provider
    @Autowired(name = Constant.PROVIDER_NEWS)
    lateinit var newsProvider: NewsProvider;
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.title.text = newsProvider.getNews().title
        Log.d(TAG, "onCreate1: ${newsProvider.getNews()}")
        // 通过 ARoute 主动获取Provider
        val provider: NewsProvider = ARouter.getInstance().navigation(NewsProvider::class.java)
        Log.d(TAG, "onCreate2: ${provider.getNews()}")
        val newsFragment = ARouter.getInstance().build(Constant.FRAGMENT_NEWS).navigation()
        Log.d(TAG, "onCreate: $newsFragment")
    }

    fun nextActivity(view: View) {
        ARouter.getInstance().build(Constant.SECOND_ACTIVITY)
            .withString("title", "你好")
            .withObject("news", NewsBean("头条"))
            .navigation(this, object : NavCallback() {
                override fun onArrival(postcard: Postcard?) {
                    Log.d(TAG, "onArrival: ")
                    // 路由到达时调用
                }

                override fun onInterrupt(postcard: Postcard?) {
                    super.onInterrupt(postcard)
                    // 路由被拦截时调用
                }

                override fun onLost(postcard: Postcard?) {
                    super.onLost(postcard)
                    // 路由被丢失时调用
                }

                override fun onFound(postcard: Postcard?) {
                    super.onFound(postcard)
                    // 路由目标被发现时调用
                }
            })
    }
}