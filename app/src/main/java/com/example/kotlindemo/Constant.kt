package com.example.kotlindemo

class Constant {
    companion object {
        const val MAIN_ACTIVITY_ROUT = "/app/MainActivity"
        const val SECOND_ACTIVITY_ROUT = "/app/SecondActivity"

        private const val MODULE = "/aroute"
        const val MAIN_ACTIVITY = "$MODULE/MainActivity"
        const val SECOND_ACTIVITY = "$MODULE/SecondActivity"
    }
}