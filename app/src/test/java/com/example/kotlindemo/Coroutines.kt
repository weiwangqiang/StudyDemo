package com.example.kotlindemo

import android.util.Log
import com.other.Data
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.lang.Runnable
import java.text.SimpleDateFormat
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}


class Coroutines {
    @JvmField
    val id: Int = 23214

    object Singleton1 {
        lateinit var name: String
    }

    companion object {
        @JvmField
        val name = "1241"
        val COMPARATOR: Comparator<Coroutines> = compareBy<Coroutines> { it.id }
    }

    private val _uiState = MutableStateFlow("020fbhqwb")

    @Test
    fun test1() = runBlocking {
        _uiState.collect {
            log(it)
        }
        _uiState.compareAndSet("020fbhqwb", "141242")
        delay(200)
    }

    @Test
    fun test() = runBlocking {
        launch(Dispatchers.IO) {
            delay(2000)
            print("launch2 ")
        }
        launch {
            delay(2000)
            print("launch1 ")
        }
        println("finish ")
    }
}

var data = SimpleDateFormat("mm:ss:SSS")
fun log(log: Any, time: Boolean = true) {
    if (time) {
        println("{${data.format(System.currentTimeMillis())} -- ${Thread.currentThread().id}} $log")
    } else {
        println("{${Thread.currentThread().id}} $log")
    }
}