package com.example.whatisyourcolour_android_v2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class ReceiverActivity: AppCompatActivity() {

    private val broad = object:BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.action) {
                "android.intent.action.SEND" -> {
                    val string = intent.getStringExtra("com.example.whatisyourcolour_android_v2.EXTRA_DATA")
                    Toast.makeText(context, string,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        val intentFilter = IntentFilter("android.intent.action.SEND")

        LocalBroadcastManager.getInstance(this).registerReceiver(broad, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broad)
    }
}
