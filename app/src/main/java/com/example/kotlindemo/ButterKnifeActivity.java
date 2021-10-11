package com.example.kotlindemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = Constant.SECOND_ACTIVITY_ROUT)
public class ButterKnifeActivity extends Activity {
    @BindView(R.id.button)
    public Button button;

    @VisibleForTesting
    private String name ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);
        button.setOnClickListener((view) -> {
            Toast.makeText(ButterKnifeActivity.this, "hello", Toast.LENGTH_SHORT).show();
        });
        ARouter.getInstance().inject(this);
    }

    private static final String TAG = "ButterKnifeActivity";
    @OnClick(R.id.button)
    public void onclick() {
        Log.d(TAG, "onclick: ");
    }
}
