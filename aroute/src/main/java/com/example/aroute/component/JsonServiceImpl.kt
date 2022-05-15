package com.example.aroute.component

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.example.aroute.Constant
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * 要传自定义对象，需要定义如下类
 */
@Route(path = Constant.JSON_ROUTE)
class JsonServiceImpl : SerializationService {
    private val gson = Gson()
    override fun init(context: Context?) {

    }

    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        return gson.fromJson(input, clazz)
    }

    override fun object2Json(instance: Any?): String {
        return gson.toJson(instance)
    }

    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T {
        return gson.fromJson(input, clazz)
    }
}