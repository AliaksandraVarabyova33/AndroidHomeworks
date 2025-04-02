package com.example.androidhomeworks

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_second)


        val editTextName = findViewById<EditText>(R.id.nameInput)
        val buttonSave = findViewById<Button>(R.id.saveButton)
        val buttonToast = findViewById<Button>(R.id.toastButton)
        val textViewGreeting = findViewById<TextView>(R.id.greetingTextView)
        val image = findViewById<ImageView>(R.id.image)

        textViewGreeting.text = getString(R.string.hi_with_name, "User")

        buttonSave.setOnClickListener() {
            val userName = editTextName.text.toString().trim()
            if (userName.isNotEmpty()) {
                textViewGreeting.text = getString(R.string.hi_with_name, userName)
                editTextName.visibility = View.GONE
                buttonSave.visibility = View.GONE
                image.visibility = View.VISIBLE

            }
        }

        buttonToast.setOnClickListener() {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }
    }
}