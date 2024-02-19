package com.jyldyzferr.travelapp.data.repositories

import android.util.Log
import com.jyldyzferr.travelapp.data.cache.sourse.FetchFromBookingCloudDataSource
import com.jyldyzferr.travelapp.data.cloud.models.booking.toDomain
import com.jyldyzferr.travelapp.data.mappers.toDomain
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    private val dataSource: FetchFromBookingCloudDataSource,
) : BookingRepository {
    override suspend fun boardingPass(): Result<List<BookingDomain>> {
        return try {
            val response = dataSource.boardingPass().map { it.toDomain() }
            Result.Success(data = response)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.i("TravelApp", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun bookingFlights(booking: BookingBasketDomain) {
        try {
            val response = dataSource.bookingFlights(booking.toDomain())
            Result.Success(data = response)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.i("TravelApp", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun fetchBookingById(objectId: String): Result<BookingDomain> {
        return try {
            val params = "{\"objectId\":\"$objectId\"}"
            val response = dataSource.fetchBookingById(params)
            val reserved = response.first().toDomain()
            Result.Success(data = reserved)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("RestaurantApp", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }
}


