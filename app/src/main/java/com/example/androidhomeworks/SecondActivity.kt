package com.example.androidhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomeworks.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}