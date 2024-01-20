package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.withTimeout

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this, ObserveFactory(application, "Factory"))[MainViewModel::class.java]
    }

    override fun onStart() {
        val textTimer = findViewById<TextView>(R.id.textView)
        textTimer.text = mViewModel.liveData.value.toString()
        super.onStart()
        mViewModel.liveData.observe(this, Observer {
            textTimer.text = it
        })
    }
}
