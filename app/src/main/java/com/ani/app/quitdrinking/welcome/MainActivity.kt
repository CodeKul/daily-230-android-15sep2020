package com.ani.app.quitdrinking.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ani.app.quitdrinking.R
import com.ani.app.quitdrinking.dashboard.DashboardActivity
import com.ani.app.quitdrinking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(WelcomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var spNm = 0

        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.welcomeViewModel = viewModel

        viewModel.letsQuit.observe(this, {
            it?.let {// kotlin scoped functions
                if (it >= 0) {
                    startActivity(Intent(this, DashboardActivity::class.java))
                } else Toast.makeText(this, "Enter Details", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.spent.observe(this, { spent ->
            spent?.let {
                if (it.isNotEmpty()) {
                    val spentNum = it.toInt()
                    if (spentNum > 100) {
                        Toast.makeText(this, "Invalid Spent", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}

