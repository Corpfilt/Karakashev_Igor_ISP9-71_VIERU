package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Menu : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }
        findViewById<Button>(R.id.btnMedia).setOnClickListener {
            startActivity(Intent(this, Media::class.java))
        }
        findViewById<Button>(R.id.btnRandom).setOnClickListener {
            startActivity(Intent(this, Random1::class.java))
        }
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finishAffinity()
        }
    }
}
