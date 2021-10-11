package com.example.kotlindemo

import android.os.*
import android.util.Log
import android.view.Choreographer
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import butterknife.BindView
import butterknife.ButterKnife
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = Constant.MAIN_ACTIVITY_ROUT)
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @BindView(R.id.view1)
    var view: Button? = null
    var lastTime: Long = 0L

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "onAttachedToWindow: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        ARouter.getInstance().inject(this)
        Log.d(TAG, "onCreate: ")
        view1.viewTreeObserver.addOnPreDrawListener {
            var n = 24
            true
        }
        view1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "hello", Toast.LENGTH_SHORT).show()
                ARouter.getInstance().build(Constant.SECOND_ACTIVITY_ROUT).navigation()
            }
        })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.d(TAG, "onPostCreate: ")
    }

    var callback = object : Choreographer.FrameCallback {
        override fun doFrame(frameTimeNanos: Long) {
            Log.d(TAG, "Choreographer: " + (frameTimeNanos - lastTime) / 1000000)
            lastTime = frameTimeNanos
            Choreographer.getInstance().postFrameCallback(this)
        }
    }
}
