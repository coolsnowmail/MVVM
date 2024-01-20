package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val myLifeData = MyLifeData()
    lateinit var observer: Observer<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editedText = findViewById<TextView>(R.id.textView)
        val editedTextButton = findViewById<View>(R.id.EditTextViewButton)
        val editTextLine = findViewById<TextView>(R.id.EditTextView)

        editedTextButton.setOnClickListener {
            myLifeData.setValueToLiveData(editTextLine.text.toString())
        }

        observer = Observer {
            editedText.text = it
        }
    }

    override fun onStart() {
        super.onStart()
        myLifeData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        myLifeData.removeObserver(observer)
    }
}
