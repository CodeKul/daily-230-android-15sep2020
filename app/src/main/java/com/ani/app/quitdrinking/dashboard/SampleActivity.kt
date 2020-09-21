package com.ani.app.quitdrinking.dashboard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ani.app.quitdrinking.R
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity() {
    private var device : String = "mobile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        swMb.setOnCheckedChangeListener { buttonView, isChecked ->
            device = if(isChecked) "tv" else "mobile"
            buttonView.text = device
        }

        btNx.setOnClickListener {
            val ctx: Context = this // source
            val typ: Class<SettingsActivity> = SettingsActivity::class.java // destination

            val bnd = Bundle() // data store
            bnd.putString("device", device) // adding data to store

            val intent = Intent(ctx, typ)
            intent.putExtras(bnd) // setting data store to intent

            startActivityForResult(intent, 1234)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1234) {
            if(resultCode == RESULT_OK) {
                swMb.text = data?.extras?.getString("dimensions")
            }
            Log.i("@ani", "You are coming back from Settings Activity")
        }

    }
}