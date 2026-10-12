package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast

/** Visual media demonstration: no actual video or audio files are required. */
class Media : Activity() {
    private val handler = Handler(Looper.getMainLooper())
    private var playing = false
    private lateinit var audioProgress: SeekBar
    private val mockProgress = object : Runnable {
        override fun run() {
            if (!playing) return
            if (audioProgress.progress >= audioProgress.max) {
                playing = false
                return
            }
            audioProgress.progress = audioProgress.progress + 1
            handler.postDelayed(this, 200L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)
        audioProgress = findViewById(R.id.audioProgress)
        if (savedInstanceState != null) {
            audioProgress.progress = savedInstanceState.getInt("mockProgress", 0)
        }
        findViewById<ImageView>(R.id.videoPlaceholder).setOnClickListener {
            Toast.makeText(this, R.string.media_placeholder_notice, Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            if (!playing) {
                playing = true
                handler.removeCallbacks(mockProgress)
                handler.post(mockProgress)
            }
        }
        findViewById<Button>(R.id.btnPause).setOnClickListener {
            playing = false
            handler.removeCallbacks(mockProgress)
        }
        findViewById<Button>(R.id.btnStop).setOnClickListener {
            playing = false
            handler.removeCallbacks(mockProgress)
            audioProgress.progress = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("mockProgress", audioProgress.progress)
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        playing = false
        handler.removeCallbacks(mockProgress)
        super.onStop()
    }
}
