package com.ani.app.quitdrinking

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ani.app.quitdrinking.dashboard.dao.DashboardDao
import com.ani.app.quitdrinking.dashboard.domain.Dashboard

@Database( entities = [Dashboard::class], version = 1)
abstract class AppDb: RoomDatabase() {
    abstract fun dashboardDao() : DashboardDao
}