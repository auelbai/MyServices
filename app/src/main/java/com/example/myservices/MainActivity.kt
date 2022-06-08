package com.example.myservices

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.myservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.simpleService.setOnClickListener {
            startService(MyService.newIntent(this))
        }

        binding.foregroundService.setOnClickListener {
            ContextCompat.startForegroundService(this, MyForegroundService.newIntent(this))
        }
    }
}