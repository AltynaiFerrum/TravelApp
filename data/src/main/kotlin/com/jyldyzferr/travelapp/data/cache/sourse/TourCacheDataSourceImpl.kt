package com.jyldyzferr.travelapp.data.cache.sourse

import com.jyldyzferr.travelapp.data.cache.dao.TourDao
import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TourCacheDataSourceImpl @Inject constructor(
    private val tourDao: TourDao,
    ): TourCacheDataSource {

    override suspend fun addNewTour(tour: TourDetailsCache){
        tourDao.addNewTour(tour)
    }

    override suspend fun deleteTourById(tourId: String) {
        tourDao.deleteTourById(tourId)
    }

    override fun fetchAllSavedTours(): Flow<List<TourDetailsCache>> {
       return tourDao.fetchAllSavedTours()
    }

    override fun isTourSavedFlow(tourId: String): Flow<Boolean> {
       return tourDao.isTourSaved(tourId)
    }
}