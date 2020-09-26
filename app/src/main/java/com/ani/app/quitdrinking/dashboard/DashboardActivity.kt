package com.ani.app.quitdrinking.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ani.app.quitdrinking.App
import com.ani.app.quitdrinking.R
import com.ani.app.quitdrinking.dashboard.viewmodel.DashboardViewModel
import com.ani.app.quitdrinking.databinding.ActivityDashboardBinding
import kotlinx.coroutines.*
import java.util.*

class DashboardActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(DashboardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityDashboardBinding>(this, R.layout.activity_dashboard)
        binding.dashVm = viewModel

        CoroutineScope(Dispatchers.IO).launch {
            val data = (application as App).db.dashboardDao().timestamps().first()
           dateDiff(data.id)
        }
    }

    private fun dateDiff(tm: Long) {
        val estDateInLong = tm
        val currentTimeinLong = Calendar.getInstance().timeInMillis
        var diff = (currentTimeinLong - estDateInLong)
        val diffDay = diff / (24 * 60 * 60 * 1000);
        diff -= (diffDay * 24 * 60 * 60 * 1000);
        val diffHours = diff / (60 * 60 * 1000);
        diff -= (diffHours * 60 * 60 * 1000);
        val diffMinutes = diff / (60 * 1000);
        diff -= (diffMinutes * 60 * 1000);
        val diffSeconds = diff / 1000;
        diff -= (diffSeconds * 1000);

        Log.i("@ani", "Days - ${diffDay} Hours - ${diffHours} Minutes - ${diffMinutes}")

        viewModel.dhm.value = " 8 8 8 "
        //viewModel.setData()
    }
}