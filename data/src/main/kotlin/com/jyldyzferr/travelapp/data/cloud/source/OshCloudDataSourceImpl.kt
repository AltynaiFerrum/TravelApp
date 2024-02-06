package com.jyldyzferr.travelapp.data.cloud.source

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud
import com.jyldyzferr.travelapp.data.cloud.service.OshService
import java.util.concurrent.CancellationException
import javax.inject.Inject

class OshCloudDataSourceImpl @Inject constructor(
    private val oshService: OshService
) : OshCloudDataSource {
    override suspend fun fetchAllTours(): List<ToursNewCloud> {
        return try {
            oshService.fetchAllTours().results
//            if (response.isSuccessful) response.body()?.results ?: emptyList()
//            else emptyList()
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
            oshService.fetchTourById(params).results
//            if (response.isSuccessful) response.body()?.results ?: emptyList()
//            else emptyList()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            emptyList()
        }
    }

//    override suspend fun fetchTours(
//        tourId: String
//    ): List<OshCloud> {
//       return try {
//            val response = oshService.fetchTours(
//                tourId
//            )
//            if (response.isSuccessful) response.body()?.results ?: emptyList()
//            else emptyList()
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.e("TravelApp", e.stackTraceToString())
//            emptyList()
//        }
//    }


//    override suspend fun fetchTourById(tourId: String): OshCloud {
//        return try {
//            oshService.fetchTourById(tourId)
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.e("TravelApp", e.stackTraceToString())
//            OshCloud.unknown()
//        }
//    }
}