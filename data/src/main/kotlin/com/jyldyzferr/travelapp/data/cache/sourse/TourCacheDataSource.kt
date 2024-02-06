package com.jyldyzferr.travelapp.data.cache.sourse

import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache
import kotlinx.coroutines.flow.Flow

interface TourCacheDataSource {

   suspend fun addNewTour(tour: TourDetailsCache)

    suspend fun deleteTourById(tourId: String)

    fun fetchAllSavedTours(): Flow<List<TourDetailsCache>>

    fun isTourSavedFlow(tourId: String): Flow<Boolean>
}