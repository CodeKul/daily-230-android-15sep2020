package com.ani.app.quitdrinking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    val spent : MutableLiveData<Int> = MutableLiveData()
    val days : MutableLiveData<Int> = MutableLiveData()
}