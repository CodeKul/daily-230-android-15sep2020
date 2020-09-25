package com.ani.app.quitdrinking.dashboard.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dashboard_data")
data class Dashboard(
    @PrimaryKey
    val id : Long,
    val spent : Int,
    val days : Int
)