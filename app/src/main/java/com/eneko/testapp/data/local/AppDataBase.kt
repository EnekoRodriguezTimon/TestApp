package com.eneko.testapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eneko.testapp.data.local.daos.ItemDao
import com.eneko.testapp.data.local.entities.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}