package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import kotlinx.coroutines.flow.Flow


interface TourRepository {
    suspend fun fetchAllTours(): Result<List<ToursNewDomain>>

    suspend fun fetchToursById(objectId: String): Result<ToursNewDomain>

    suspend fun searchByQuery(query: String): List<ToursNewDomain>



    fun fetchAllSavedTours(): Flow<List<ToursNewDomain>>


    fun isTourSavedFlow(tourId: String): Flow<Boolean>

    suspend fun addNewTour(tour: ToursNewDomain)

    suspend fun deleteTourById(tourId: String)

}