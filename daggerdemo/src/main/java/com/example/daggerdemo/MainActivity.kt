package com.example.daggerdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.daggerdemo.base.MainContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.IView {

    lateinit var text: TextView

    @Inject
    lateinit var presenter: MainContract.IPresenter

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.dagger_text)
        presenter.takeView(this)
        text.setOnClickListener {
            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        presenter.getData()
    }

    override fun showText(content: String) {
        text.setText(content)
    }
}