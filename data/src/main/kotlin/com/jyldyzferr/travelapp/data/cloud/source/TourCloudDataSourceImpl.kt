package com.jyldyzferr.travelapp.data.cloud.source

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud
import com.jyldyzferr.travelapp.data.cloud.models.tours.toDomain
import com.jyldyzferr.travelapp.data.cloud.service.TourService
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import java.util.concurrent.CancellationException
import javax.inject.Inject

class TourCloudDataSourceImpl @Inject constructor(
    private val tourService: TourService
) : TourCloudDataSource {
    override suspend fun fetchAllTours(): List<ToursNewCloud> {
        return try {
            tourService.fetchAllTours().results
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("RestaurantApp", e.stackTraceToString())
            emptyList()
        }
    }

    override suspend fun fetchToursById(objectId: String): List<ToursNewCloud> {
        return try {
            val params = "{\"objectId\":\"$objectId\"}"
            tourService.fetchTourById(params).results
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            emptyList()
        }
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
}