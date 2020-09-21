package com.ani.app.quitdrinking.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ani.app.quitdrinking.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val bnd = intent?.extras
        val device = bnd?.getString("device")
        txtDt.text = device
    }
}