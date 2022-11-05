package com.example.livedata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

class MainActivity : AppCompatActivity() {
    lateinit var showText: Button;
    var liveData = StockLiveData.get()

    companion object {
        private const val TAG = "MainActivity"
    }

    var observer = Observer<String> {
        Log.d(TAG, "no lifecycle Observer: value => $it")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showText = findViewById(R.id.showText)
        // 传入LifecycleOwner，并观察livedata的值
        StockLiveData.get().observe(this, {
            // 显示更新后的值
            showText.text = it
        })
        liveData.value = "init"
        lifecycle.addObserver(LifecycleWatcher())
    }

    override fun onResume() {
        super.onResume()
//        liveData.observeForever(observer)
    }

    // 点击回调事件，让Livedata更新值
    fun onMainThread(view: View) {
        liveData.value = "from main thread "
    }

    // 子线程更新livedata的值
    fun onWorkThread(view: View) {
        Thread {
            liveData.postValue("from work thread")
        }.start()
    }

    // 模拟后台耗时任务，回到activity重新显示最新的值
    override fun onStop() {
        super.onStop()
//        liveData.removeObserver(observer)
//        Thread {
//            Thread.sleep(1000)
//            liveData.postValue("from back work thread")
//        }.start()
    }

    class LifecycleWatcher : LifecycleEventObserver {

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            Log.d(TAG, "onStateChanged: lifecycle ${event.name} state ${event.targetState}")
        }
    }

    fun toSecondActivity(view: View) {
        var intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}