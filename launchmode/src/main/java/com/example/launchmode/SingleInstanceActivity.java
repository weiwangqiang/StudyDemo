package com.example.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SingleInstanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
    }

    public void next(View view) {
        Log.d(TAG, "------------- start activity -------------");
        Intent intent = new Intent(this, OtherSingleInstanceActivity.class);
        startActivity(intent);
    }
}