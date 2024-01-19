package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {

    private val getData = GetData()
    private val lifeDateString = MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifeDateString.value = "Hello life data"
        val test_text = findViewById<TextView>(R.id.test_text)
        test_text.text = lifeDateString.value
    }
}
