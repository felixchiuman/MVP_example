package com.felix.mvpexample

interface MainView {
    fun showMessage(message: String)

    fun showData(data: String)

    fun clearField()
}