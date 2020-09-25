package com.ani.app.quitdrinking.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ani.app.quitdrinking.App
import com.ani.app.quitdrinking.R
import com.ani.app.quitdrinking.dashboard.DashboardActivity
import com.ani.app.quitdrinking.dashboard.domain.Dashboard
import com.ani.app.quitdrinking.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(WelcomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isFirstLogin()) {
            startActivity(Intent(this, DashboardActivity::class.java))
        } else {
            val binding = DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            binding.welcomeViewModel = viewModel


            viewModel.letsQuit.observe(this, {
                it?.let {// kotlin scoped functions
                    if (it >= 0) {
                        (application as App).db.dashboardDao().deleteAll()

                        (application as App).db.dashboardDao().saveData(
                            Dashboard(
                                id = System.currentTimeMillis(),
                                spent = viewModel.toNumber(viewModel.spent),
                                days = viewModel.toNumber(viewModel.days)
                            )
                        )
                        startActivity(Intent(this, DashboardActivity::class.java))
                    } else Toast.makeText(this, "Enter Details", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun isFirstLogin(): Boolean {
        CoroutineScope(Dispatchers.IO).launch {
            this.async {

            }
        }
        return (application as App).db.dashboardDao().timestamps().isEmpty()
    }
}

