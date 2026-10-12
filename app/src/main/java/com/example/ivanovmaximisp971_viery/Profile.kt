package com.example.ivanovmaximisp971_viery

import android.app.Activity
import android.os.Bundle

/** Profile inputs are intentionally editable but not persisted (UI demonstration). */
class Profile : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}
