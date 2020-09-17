package com.ani.app.quitdrinking

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ani.app.quitdrinking.databinding.ActivityMainBinding

// LoginActivity -> ActivityLoginBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val view = View(this) // R.layout.activity_main --> compiled -> view
//        setContentView(R.layout.activity_main)
//        val currObj : MainActivity = this

        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}

