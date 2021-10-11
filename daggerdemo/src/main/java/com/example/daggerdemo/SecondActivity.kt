package com.example.daggerdemo

import android.os.Bundle
import android.util.Log
import com.example.daggerdemo.base.MainContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity(), MainContract.IView {
    @Inject
    lateinit var presenter: MainContract.IPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        presenter.takeView(this)
        presenter.getData()
    }

    private val TAG = "SecondActivity"
    override fun showText(text: String) {
        Log.d(TAG, "showText: " + text)
    }
}