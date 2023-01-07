package com.example.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.Inet4Address;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        Log.d(TAG, "------------- start activity -------------");
        Intent intent = new Intent(this, SingleInstanceActivity.class);
        startActivity(intent);
    }
}