package com.ani.app.quitdrinking.dashboard

import android.content.Intent
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
        txtDim.text = processData(device)

        btBk.setOnClickListener {

            val bn = Bundle()
            bn.putString("dimensions", processData(device))

            val bkIn = Intent() // data -> no source and destination
            bkIn.putExtras(bn)

            setResult(RESULT_OK, bkIn)
            finish()
        }
    }

    private fun processData(device : String?) : String {
        return when(device) {
            "tv" -> "1024 * 768"
            "mobile" -> "300 * 400"
            else -> "unknown"
        }
    }
}