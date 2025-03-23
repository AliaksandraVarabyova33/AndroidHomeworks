package com.example.androidhomeworks

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        textView = findViewById<TextView>(R.id.textView)

        //task4: Передай имя пользователя из MainActivity в SecondActivity
        val options = intent.extras
        if (options != null) {
            setText(options.getString("userName", "Human"))
        }
    }

    private fun setText(text: String) {
        textView.text = buildString {
            append("Well Done, ")
            append(text)
        }
    }
}