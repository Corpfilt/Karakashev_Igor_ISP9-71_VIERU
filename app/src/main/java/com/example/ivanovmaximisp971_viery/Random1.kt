package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

/** All behaviour here is local UI-only. No backend or database. */
class Random1 : Activity() {
    private var value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random1)
        value = savedInstanceState?.getInt("counter") ?: 0
        val numberText = findViewById<TextView>(R.id.txtNumber)
        fun refresh() { numberText.text = value.toString() }
        refresh()
        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            value = (value + 1).coerceAtMost(999)
            refresh()
        }
        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            value = (value - 1).coerceAtLeast(0)
            refresh()
        }
        findViewById<Button>(R.id.btnGenerate).setOnClickListener {
            startActivity(Intent(this, Random2::class.java).putExtra("result", Random.nextInt(0, 1000)))
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("counter", value)
        super.onSaveInstanceState(outState)
    }
}
