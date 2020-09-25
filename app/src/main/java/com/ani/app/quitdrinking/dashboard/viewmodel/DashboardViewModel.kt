package com.ani.app.quitdrinking.dashboard.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {

    val dhm : MutableLiveData<String> = MutableLiveData("0d 0m 0h")

    fun setData() {
        dhm.postValue("45 45 45")
    }
}