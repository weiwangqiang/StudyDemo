package com.example.kotlindemo.viewbinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kotlindemo.databinding.ActivityViewBindingBinding;

public class ViewBindingActivity extends AppCompatActivity {
    private ActivityViewBindingBinding activityViewBinding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityViewBinding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(activityViewBinding.getRoot());
        activityViewBinding.viewBindingView.setText("你好，我是viewBinding");
    }
}
