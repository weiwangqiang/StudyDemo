package com.example.daggerdemo.base

interface MainContract {
    interface IView {
        fun showText(text: String)
    }

    interface IPresenter {
        fun takeView(view: IView)
        fun dropView()
        fun getData()
    }
}