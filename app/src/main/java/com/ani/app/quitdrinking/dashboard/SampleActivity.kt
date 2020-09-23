package com.ani.app.quitdrinking.dashboard

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.location.LocationManagerCompat
import com.ani.app.quitdrinking.R
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity() {
    private var device : String = "mobile"
    private var isFromLoc = false

    //https://stackoverflow.com/questions/25175522/how-to-enable-location-access-programmatically-in-android/25175756
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        swMb.setOnCheckedChangeListener { buttonView, isChecked ->
            if(!isFromLoc) {
                device = if (isChecked) "tv" else "mobile"
                buttonView.text = device
            }
            if(isChecked) {
                if(!isLocationEnabled())
                    locationSettingsActivity()
            }

            isFromLoc = false
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
        if(requestCode == REQUEST_SETTINGS) {
            if(resultCode == RESULT_OK) {
                swMb.text = data?.extras?.getString("dimensions")
            }
            Log.i("@ani", "You are coming back from Settings Activity")
        }
        if(requestCode == REQUEST_LOCATION_SETTINGS) {
            Log.i("@ani", "REsult is ${resultCode}")
            isFromLoc = true
            swMb.text = if(isLocationEnabled()) "enabled" else "disabled"
            swMb.isChecked = isLocationEnabled()
        }
    }

    private fun locationSettingsActivity() {
        val callGPSSettingIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivityForResult(callGPSSettingIntent, REQUEST_LOCATION_SETTINGS)
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return LocationManagerCompat.isLocationEnabled(locationManager)
    }

    companion object {
        const val REQUEST_SETTINGS = 1234
        const val REQUEST_LOCATION_SETTINGS = 4568
    }
}