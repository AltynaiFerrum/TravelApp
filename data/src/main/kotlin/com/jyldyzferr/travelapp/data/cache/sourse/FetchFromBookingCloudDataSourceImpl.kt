package com.jyldyzferr.travelapp.data.cache.sourse

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingCloud
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingParams
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingResponse
import com.jyldyzferr.travelapp.data.cloud.service.BookingService
import java.util.concurrent.CancellationException
import javax.inject.Inject

class FetchFromBookingCloudDataSourceImpl @Inject constructor(
    private val service: BookingService
) : FetchFromBookingCloudDataSource {
    override suspend fun boardingPass(): List<BookingCloud> {
        return try {
            val response = service.boardingPass()
            if (response.isSuccessful) response.body()?.results ?: emptyList()
            else emptyList()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.i("Travel App", e.stackTraceToString())
            emptyList()
        }
    }

    override suspend fun bookingFlights(booking: BookingParams) {
        try {
            val response = service.bookingFlights(booking)
            if (response.isSuccessful) response.body() ?: String()
            else String()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.i("Travel App", e.stackTraceToString())
            String()
        }    }

    override suspend fun fetchBookingById(objectId: String): List<BookingCloud> {
        return try {
            val reserved = service.fetchBookingById(objectId)
            if (reserved.isSuccessful) reserved.body()?.results ?: emptyList()
            else emptyList()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("Travel App", e.stackTraceToString())
            emptyList()
        }
    }
}