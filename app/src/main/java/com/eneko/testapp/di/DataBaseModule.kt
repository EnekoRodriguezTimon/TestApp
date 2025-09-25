package com.eneko.testapp.di

import android.content.Context
import androidx.room.Room
import com.eneko.testapp.data.local.AppDatabase
import com.eneko.testapp.data.local.daos.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideItemDao(db: AppDatabase): ItemDao {
        return db.itemDao()
    }
}