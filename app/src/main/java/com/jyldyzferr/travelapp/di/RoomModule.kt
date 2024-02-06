package com.jyldyzferr.travelapp.di

import android.content.Context
import androidx.room.Room
import com.jyldyzferr.travelapp.data.cache.dao.TourDao
import com.jyldyzferr.travelapp.data.cache.database.TourDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


private const val TOUR_DATABASE_NAME = "tours_database"
@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): TourDatabase = Room.databaseBuilder(
        context,
        TourDatabase::class.java,
        TOUR_DATABASE_NAME
    ).build()

    @Provides
    fun provideTourDao(
        database: TourDatabase
    ): TourDao = database.tourDao()
}