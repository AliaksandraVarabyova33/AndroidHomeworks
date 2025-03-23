package com.example.androidhomeworks

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var userName: TextView

    //task6
    private val receiverWiFi = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == WifiManager.WIFI_STATE_CHANGED_ACTION) {
                val wifiState = intent.getIntExtra(
                    WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN
                )
                if (wifiState == WifiManager.WIFI_STATE_ENABLED
                ) {
                    Log.d("WIFI_test", "WIFI is on")
                } else if (wifiState == WifiManager.WIFI_STATE_DISABLED) {
                    Log.d("WIFI_test", "WIFI is off")
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button)
        userName = findViewById<TextView>(R.id.userName)
        setButtonText()
        setText()
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //task4: Передай имя пользователя из MainActivity в SecondActivity
            intent.putExtra("userName", userName.text.toString())
            startActivity(intent)
        }

        //task6
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(receiverWiFi, intentFilter)
        Log.d("LIFECYCLE", "onCreate")

    }

    private fun setButtonText() {
        button.text = buildString {
            append("Click On Me, ")
            //task5:Получите строку из ресурсов в Context
            append(getString(R.string.task5))
        }
    }

    private fun setText() {
        //task5:Получите строку из ресурсов в Context
        userName.text = getString(R.string.task5)
    }


    override fun onDestroy() {
        super.onDestroy()
        //task6
        unregisterReceiver(receiverWiFi)
        Log.d("LIFECYCLE", "onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "onRestart")
    }

}