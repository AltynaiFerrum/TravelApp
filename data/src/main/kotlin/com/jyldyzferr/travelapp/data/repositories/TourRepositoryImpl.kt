package com.jyldyzferr.travelapp.data.repositories

import android.util.Log
import com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource
import com.jyldyzferr.travelapp.data.cloud.models.tours.toDomain
import com.jyldyzferr.travelapp.data.cloud.service.TourService
import com.jyldyzferr.travelapp.data.mappers.toCache
import com.jyldyzferr.travelapp.data.mappers.toDomain
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.TourRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.CancellationException
import javax.inject.Inject


class TourRepositoryImpl @Inject constructor(
    private val cacheDataSource: TourCacheDataSource,
    private val tourService: TourService,
    ) : TourRepository {
    override suspend fun fetchAllTours(): Result<List<ToursNewDomain>> {
        return try {
            val tours = tourService.fetchAllTours().results
            Result.Success(data = tours.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(message = DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun fetchToursById(objectId: String): Result<ToursNewDomain> {
        return try {
            val params = "{\"objectId\":\"$objectId\"}"
            val response = tourService.fetchTourById(params)
            val tour = response.results?.first()?.toDomain() ?: ToursNewDomain.unknown
            Result.Success(data = tour)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }


    override fun fetchAllSavedTours(): Flow<List<ToursNewDomain>> {
        return cacheDataSource.fetchAllSavedTours().map { it.map { it.toDomain() } }
    }


    override suspend fun searchByQuery(query: String): List<ToursNewDomain> {
        return try {
            val params = "{\"name\":\"$query\"}"
            val response = tourService.searchByQuery(params)
            val result = response.results
             result.map { it.toDomain() }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            emptyList()
        }
    }


    override fun isTourSavedFlow(tourId: String): Flow<Boolean> {
        return cacheDataSource.isTourSavedFlow(tourId)
    }

    override suspend fun addNewTour(tour: ToursNewDomain) {
        cacheDataSource.addNewTour(tour = tour.toCache())
    }

    override suspend fun deleteTourById(tourId: String) {
        cacheDataSource.deleteTourById(tourId)
    }
}