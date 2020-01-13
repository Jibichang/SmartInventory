package org.lox.smartinventory.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface InvDatabaseDao {
    @Insert
    fun insert(inv: Inventory)

    @Update
    fun update(inv: Inventory)

    @Query("SELECT * FROM inv_table WHERE itemId = :key")
    fun get(key: Long): Inventory

    @Query("DELETE FROM inv_table")
    fun clear()

    @Query("SELECT * FROM inv_table ORDER BY itemId DESC")
    fun getAllItems(): LiveData<List<Inventory>>

    @Query("SELECT * FROM inv_table ORDER BY itemId DESC LIMIT 1")
    fun getLast(): Inventory?

    @Query("SELECT * from inv_table WHERE itemId = :key")
    fun getItemWithId(key: Long): LiveData<Inventory>
}