package org.lox.smartinventory.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inv_table")
data class Inventory (
    @PrimaryKey(autoGenerate = true)
    var itemId :Long = 0L,

    @ColumnInfo(name = "name")
    var itemName :String,

    @ColumnInfo(name = "stock")
    var itemStock :String,

    @ColumnInfo(name = "predict")
    var predict :String,

    @ColumnInfo(name = "date_now")
    val startTimeMilli: Long = System.currentTimeMillis()
)