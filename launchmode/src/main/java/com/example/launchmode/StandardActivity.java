package com.example.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StandardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void next(View view) {
        Log.d(TAG, "------------- start activity -------------");
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
    }
}