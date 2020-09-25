package com.ani.app.quitdrinking.dashboard.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ani.app.quitdrinking.dashboard.domain.Dashboard

@Dao
interface DashboardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveData(data : Dashboard)

    @Query("select * from dashboard_data")
    fun timestamp(): Long
}