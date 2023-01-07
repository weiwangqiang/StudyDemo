package com.example.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SingleTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }

    public void next(View view) {
        Log.d(TAG, "------------- start activity -------------");
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
    }
}