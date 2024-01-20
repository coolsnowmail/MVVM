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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editedText = findViewById<TextView>(R.id.textView)
        val editedTextButton = findViewById<View>(R.id.EditTextViewButton)
        val editTextLine = findViewById<TextView>(R.id.EditTextView)

//        editButton.setOnClickListener {
//            println("!!! ${myLifeData.value}")
//            myLifeData.setValueToLiveData(editedText.text.toString())
//            println("!!! ${myLifeData.value}")
//        }
        myLifeData.observe(this, Observer {  })
    }
}
