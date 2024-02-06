package com.jyldyzferr.travelapp.data.cloud.source

import com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud


interface OshCloudDataSource {
    suspend fun fetchAllTours(): List<ToursNewCloud>
    suspend fun fetchToursById(objectId: String): List<ToursNewCloud>

}