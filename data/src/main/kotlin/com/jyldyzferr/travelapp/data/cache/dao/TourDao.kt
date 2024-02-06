package com.jyldyzferr.travelapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache
import dagger.Provides
import kotlinx.coroutines.flow.Flow

@Dao
interface TourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewTour(tour: TourDetailsCache)

    @Query("DELETE FROM tours_table WHERE id = :tourId")
    fun deleteTourById(tourId: String)

    @Query("SELECT * FROM tours_table")
    fun fetchAllSavedTours(): Flow<List<TourDetailsCache>>

    @Query("SELECT EXISTS (SELECT 1 FROM tours_table WHERE id = :tourId) ")
    fun isTourSaved(tourId: String): Flow<Boolean>
}