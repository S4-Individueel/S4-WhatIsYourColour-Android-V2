package com.example.whatisyourcolour_android_v2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    private lateinit var broadCastButton: Button
    private lateinit var navigateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        broadCastButton = findViewById(R.id.button)
        navigateButton = findViewById(R.id.navigate)

        broadCastButton.setOnClickListener {
            val intent = Intent("android.intent.action.SEND")
            intent.putExtra("com.example.whatisyourcolour_android_v2.EXTRA_DATA", "sender send data")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

            Toast.makeText(this, "Send string to broadcast", Toast.LENGTH_LONG).show()
        }

        navigateButton.setOnClickListener {
            val intent = Intent(this, ReceiverActivity::class.java)
            startActivity(intent)
        }
    }
}
