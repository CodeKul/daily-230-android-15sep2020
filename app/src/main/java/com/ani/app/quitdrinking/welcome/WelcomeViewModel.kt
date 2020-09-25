package com.ani.app.quitdrinking.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _letsQuit = MutableLiveData(-1)
    val letsQuit : LiveData<Int> = _letsQuit

    val spent : MutableLiveData<String> = MutableLiveData()
    val days : MutableLiveData<String> = MutableLiveData()

    fun letsQuit() {
        if( ( (toNumber(spent) > 0) && (toNumber(spent) <= 100)) && (toNumber(days) > 0)) {
            _letsQuit.value = _letsQuit.value?.plus(1)
        }
        else _letsQuit.value = -1
    }

    fun toNumber(data : LiveData<String>): Int {
        return data.value?.let {
            if(it.isEmpty()) 0 else it.toInt()
        } ?: 0
    }
}