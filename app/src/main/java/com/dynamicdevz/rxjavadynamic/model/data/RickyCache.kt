package com.dynamicdevz.rxjavadynamic.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ricky_cache")
data class RickyCache(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cache_id")
    val cacheID: Int,

    @ColumnInfo(name = "data")
    val data: String
)
