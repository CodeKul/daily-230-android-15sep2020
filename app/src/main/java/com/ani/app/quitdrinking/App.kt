package com.ani.app.quitdrinking

import android.app.Application
import androidx.room.Room

class App : Application() {

    val db : AppDb by lazy {
        Room.databaseBuilder(
            this,
            AppDb::class.java,
            "quit_drinking"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        db
    }
}