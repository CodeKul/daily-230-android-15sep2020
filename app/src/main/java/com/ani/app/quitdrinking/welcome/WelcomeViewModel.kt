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
        var spentNum = 0
        var daysNum = 0

        spent.value?.let {
            spentNum = if(it.isEmpty()) 0 else it.toInt()
        }
        days.value?.let {
            daysNum = if(it.isEmpty()) 0 else it.toInt()
        }

        if( ( (spentNum > 0) && (spentNum <= 100)) && (daysNum > 0)) {
            _letsQuit.value = _letsQuit.value?.plus(1)
        }
        else _letsQuit.value = -1
    }
}