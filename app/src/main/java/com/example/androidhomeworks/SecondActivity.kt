package com.example.androidhomeworks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomeworks.MainActivity.Companion.ACTIVITY_STRING_KEY

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        textView = findViewById(R.id.textView)
        textView.text = intent.getStringExtra(ACTIVITY_STRING_KEY)

        val text = getString(R.string.my_fragment)
        showMyFragment(text)
    }

    private fun showMyFragment(text: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.myFragmentContainer, MyFragment.getInstance(text))
            .commit()
    }
}