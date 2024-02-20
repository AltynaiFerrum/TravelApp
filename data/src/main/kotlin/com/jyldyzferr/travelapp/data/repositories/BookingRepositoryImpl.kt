package com.jyldyzferr.travelapp.data.repositories

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingParams
import com.jyldyzferr.travelapp.data.cloud.service.BookingService
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBodyDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
//    private val dataSource: FetchFromBookingCloudDataSource,
    private val service: BookingService

) : BookingRepository {
//    override suspend fun boardingPass(): Result<List<BookingDomain>> {
//        return try {
//            val response = dataSource.boardingPass().map { it.toDomain() }
//            Result.Success(data = response)
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.i("TravelApp", e.stackTraceToString())
//            Result.Error(DEFAULT_ERROR_MESSAGE)
//        }
//    }

    override suspend fun bookingFlights(
        location: String,
        destination: String,
        departure: String,
        returnDate: String,
        passport: String
    ): Result<BookingBodyDomain> = try {
        val params = BookingParams(
            departure = departure,
            destination = destination,
            location = location,
            passport = passport,
            returnDate = returnDate
        )
        val response = service.bookingFlights(params)
        val result = response.body()!!
        Result.Success(
            BookingBodyDomain(
                id = result.id,
            )
        )
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.e("Travel App", e.stackTraceToString())
        Result.Error(DEFAULT_ERROR_MESSAGE)
    }

//    override suspend fun bookingFlights(booking: BookingBasketDomain) {
//        try {
//            val response = dataSource.bookingFlights(booking.toDomain())
//            Result.Success(data = response)
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.i("TravelApp", e.stackTraceToString())
//            Result.Error(DEFAULT_ERROR_MESSAGE)
//        }
//    }
//
//    override suspend fun fetchBookingById(objectId: String): Result<BookingDomain> {
//        return try {
//            val params = "{\"objectId\":\"$objectId\"}"
//            val response = dataSource.fetchBookingById(params)
//            val reserved = response.first().toDomain()
//            Result.Success(data = reserved)
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.e("RestaurantApp", e.stackTraceToString())
//            Result.Error(DEFAULT_ERROR_MESSAGE)
//        }
//    }
}


