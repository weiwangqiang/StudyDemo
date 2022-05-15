package com.example.aroute.component

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService
import com.example.aroute.Constant

private const val TAG = "DegradeServiceImpl"

/**
 * 自定义全局降级策略，即在没有找到路由的时候触发
 */
@Route(path = Constant.GLOBAL_CATEGORY)
class DegradeServiceImpl : DegradeService {
    override fun init(context: Context?) {
        Log.d(TAG, "init: ")
    }

    override fun onLost(context: Context?, postcard: Postcard?) {
        Log.d(TAG, "onLost: $postcard")
    }
}