package com.example.kotlindemo

import android.support.constraint.solver.widgets.Rectangle
import android.util.Log
import android.view.View
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Okio
import okio.buffer
import okio.sink
import okio.source
import org.junit.Test
import java.io.File
import java.lang.Exception
import kotlin.reflect.KProperty


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.comtools/testing).
 */
class ExampleUnitTest {

    companion object {
        val TAG: Add = Add("qrqe")
    }

    @Test
    fun addition_isCorrect() {
    }

    class Add(var name: String) {
        init {
            println("receive $name")
        }

        fun getValue(): String {
            return name
        }

        fun setValue(value: Int) {
            println(value)
        }
    }
}
