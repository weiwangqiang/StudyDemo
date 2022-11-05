package com.example.kotlindemo.fps;

import android.content.Context;
import android.util.Log;

import com.github.moduth.blockcanary.BlockCanaryContext;
import com.github.moduth.blockcanary.internal.BlockInfo;

public class AppBlockCanaryContext extends BlockCanaryContext {
    private static final String TAG = "AppBlockCanaryContext";

    @Override
    public void onBlock(Context context, BlockInfo blockInfo) {
        super.onBlock(context, blockInfo);
        Log.d(TAG, "onBlock: " + blockInfo.model);
    }

    @Override
    public int provideBlockThreshold() {
        return 200;
    }
}
