package com.example.kotlindemo.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.example.kotlindemo.R

/**
 *  通过LifecycleRegistry ，把LifeCycleOwner的周期暴露出去。
 *  但有一定局限性：不能代表完整的周期
 */
class LifecycleActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.addObserver(LifeCycleListener(lifecycle))
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED)
    }

    public override fun onStart() {
        super.onStart()
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED)
    }

    public override fun onStop() {
        super.onStop()
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}