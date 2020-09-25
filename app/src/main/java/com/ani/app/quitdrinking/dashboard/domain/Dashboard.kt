package com.ani.app.quitdrinking.dashboard.domain

import androidx.room.Entity

@Entity(tableName = "dashboard_data")
data class Dashboard(
    val id : Long,
    val spent : Int,
    val days : Int
)