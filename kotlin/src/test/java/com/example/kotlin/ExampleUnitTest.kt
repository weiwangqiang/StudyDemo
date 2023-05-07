package com.example.kotlin

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*
import java.util.Collections
import java.util.Vector

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    suspend fun main() {
        val job = GlobalScope.launch {
            delay(1000)
            println("hello")
        }
        job.join()
    }

    @Test
    fun test() = runBlocking  {
        Demo()
    }

    suspend fun Demo() {
        withContext(Dispatchers.IO) {
            println("IO ${Thread.currentThread().name} ")
            delay(1000)
        }
        withContext(Dispatchers.Main) {
            println("Default ${Thread.currentThread().name} ")
            delay(1000)
        }
        println("main ${Thread.currentThread().name} ")
    }
}