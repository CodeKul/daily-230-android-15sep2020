package com.ani.app.quitdrinking

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ani.app.quitdrinking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(WelcomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.welcomeViewModel = viewModel

        viewModel.spent.value = "10"
        viewModel.days.value = "30"

        viewModel.spent.observe(this, {
            Log.i("@ani", "Spent is $it")
        })

        viewModel.days.observe(this, {
            Log.i("@ani", "Days are $it")
        })

        viewModel.letsQuit.observe(this, {
            Log.i("@ani", "Lets Quit Clicked")
        })
    }
}

