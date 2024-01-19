package com.example.mvvm

import androidx.lifecycle.LiveData

class MyLifeData:LiveData<String> (){
    override fun onActive() {
        super.onActive()
        println("onActive")
    }

    override fun onInactive() {
        super.onInactive()
        println("onInActive")
    }
}