package com.example.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = Constant.MAIN_ACTIVITY_ROUT)
class MainActivity : AppCompatActivity() {
    var student = Student("wang", 32)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        ARouter.getInstance().inject(this)
    }

    fun press(view: View) {
        Log.d(TAG, "press: ")
        ARouter.getInstance().build(Constant.SECOND_ACTIVITY_ROUT).navigation()
    }

    private val TAG = "MainActivity"

    //接收事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun studentEventBus(student: String) {
        Log.d(TAG, "studentEventBus: " + student)
    }
}