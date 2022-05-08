package com.example.aroute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

/**
 *
 */
@Route(path = Constant.MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nextActivity(view: View) {
        ARouter.getInstance().build(Constant.SECOND_ACTIVITY).navigation()
    }
}