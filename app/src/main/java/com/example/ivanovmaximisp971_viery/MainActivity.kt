package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

/** Entrance screen; only local navigation, no network or backend. */
class MainActivity : Activity() {
    private val handler = Handler(Looper.getMainLooper())
    private val showMenu = Runnable {
        startActivity(Intent(this, Menu::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.splash_purple)
        window.navigationBarColor = getColor(R.color.splash_purple)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.splashRoot).setOnClickListener {
            handler.removeCallbacks(showMenu)
            showMenu.run()
        }
        handler.postDelayed(showMenu, 1800L)
    }

    override fun onDestroy() {
        handler.removeCallbacks(showMenu)
        super.onDestroy()
    }
}
