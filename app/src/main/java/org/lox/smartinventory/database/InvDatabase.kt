package org.lox.smartinventory.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Inventory::class], version = 1, exportSchema = false)
abstract class InvDatabase : RoomDatabase() {

    abstract val invDatabaseDao: InvDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: InvDatabase? = null

        fun getInstance(context: Context): InvDatabase {
            synchronized(this) {
                var instance = INSTANCE
                // If instance is `null` make a new database instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InvDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
