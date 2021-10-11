package com.example.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SingleTopActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
    }

    public void next(View view) {
        Log.d(TAG, " -------------- start singleTop activity --------------");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}