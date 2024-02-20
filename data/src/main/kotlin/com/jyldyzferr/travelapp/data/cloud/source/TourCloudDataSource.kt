package com.jyldyzferr.travelapp.data.cloud.source

import com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain


interface TourCloudDataSource {
    suspend fun fetchAllTours(): List<ToursNewCloud>
    suspend fun fetchToursById(objectId: String): List<ToursNewCloud>
    suspend fun searchByQuery(query: String): List<ToursNewDomain>


}