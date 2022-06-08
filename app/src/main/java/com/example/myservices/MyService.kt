package com.example.myservices

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        log("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        log("onStartCommand")

        coroutineScope.launch {
            for (i in 0 until 20) {
                delay(1000)
                Log.d("MyService: ", "$i")
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
        coroutineScope.cancel()
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun log(message: String) {
        Log.d("MyService", "Message: $message")
    }

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, MyService::class.java)
        }
    }
}