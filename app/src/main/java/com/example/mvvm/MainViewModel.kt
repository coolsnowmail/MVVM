package com.example.mvvm

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application, val text: String) : AndroidViewModel(application) {
    val liveData = MutableLiveData<String>()

    init {
        startTimer()
    }

    fun startTimer() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {
                liveData.value = (p0 / 1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show()
            }

        }.start()
    }
}