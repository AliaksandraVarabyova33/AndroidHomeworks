package com.example.androidhomeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener() {
            startSecondActivity()
        }
    }

    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(ACTIVITY_STRING_KEY, getString(R.string.activity_text))
        startActivity(intent)
    }

    companion object {
        const val ACTIVITY_STRING_KEY = "ACTIVITY_STRING"
    }
}