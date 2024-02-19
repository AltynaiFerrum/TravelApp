package com.jyldyzferr.travelapp.data.cache.sourse

import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingCloud
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingParams
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingResponse


interface FetchFromBookingCloudDataSource {

    suspend fun boardingPass(): List<BookingCloud>

    suspend fun bookingFlights(booking: BookingParams)

    suspend fun fetchBookingById(objectId: String): List<BookingCloud>
}