package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Random2 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random2)
        val result = intent.getIntExtra("result", 0).coerceIn(0, 999)
        findViewById<TextView>(R.id.txtRandomResult).text = result.toString()
    }
}
