package com.example.kotlindemo.fps

import android.util.Log
import android.view.Choreographer

/**
 * 通过Choreography 的frameCallback，监听主线程的帧率，判断是否发生丢帧的问题
 * 局限性：无法获取卡顿的堆栈
 */
class FpsManager {
    private var minSkipFps = 10

    companion object {
        private const val TAG = "FpsManager"
    }

    fun start() {
        Choreographer.getInstance().postFrameCallback(FPSCallback())
    }

    inner class FPSCallback : Choreographer.FrameCallback {
        var frameNanos = 1000_000_000L / 60
        var lastFrameTime = 0L
        override fun doFrame(frameTimeNanos: Long) {
            if (lastFrameTime == 0L) {
                lastFrameTime = frameTimeNanos
            }
            var jacketTime = frameTimeNanos - lastFrameTime
            if (jacketTime > frameNanos) {
                var skipFps = jacketTime / frameNanos
                if (skipFps > minSkipFps) {
                    Log.d(TAG, "doFrame: fuck，it skip $skipFps FPS !!!")
                }
            }
            lastFrameTime = frameTimeNanos
            Choreographer.getInstance().postFrameCallback(this)
        }
    }

}