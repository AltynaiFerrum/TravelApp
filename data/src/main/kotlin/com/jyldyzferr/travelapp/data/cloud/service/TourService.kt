package com.jyldyzferr.travelapp.data.cloud.service

import com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TourService {
    @GET("Osh")
    suspend fun fetchAllTours(): ToursNewResponse

    @GET("Osh")
    suspend fun fetchTourById(
        @Query("where") params: String
    ): ToursNewResponse

    @GET("Osh")
    suspend fun searchByQuery(
        @Query("where") query: String
    ): ToursNewResponse

}