package com.ani.app.quitdrinking.welcome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _letsQuit = MutableLiveData<Int>(0)
    val letsQuit : LiveData<Int> = _letsQuit

    val spent : MutableLiveData<String> = MutableLiveData()
    val days : MutableLiveData<String> = MutableLiveData()

    fun letsQuit() {
        _letsQuit.value = _letsQuit.value?.plus(1)
    }
}