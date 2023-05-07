package com.example.aroute;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.aroute.bean.NewsBean
import com.example.aroute.databinding.ActivitySecondBinding

@Route(path = Constant.SECOND_ACTIVITY)
class SecondActivity : BaseActivity() {
    @Autowired(name = "title")
    @JvmField
    var title: String? = null

    @Autowired
    @JvmField
    var news: NewsBean? = null

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.title.text = "$title === > ${news?.title}"
        setResult(123)
    }
}