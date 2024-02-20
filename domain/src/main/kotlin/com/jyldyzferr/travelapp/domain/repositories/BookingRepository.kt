package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBodyDomain

interface BookingRepository {
//    suspend fun boardingPass(): Result<List<BookingDomain>>

//    suspend fun bookingFlights(booking: BookingBasketDomain)

    suspend fun bookingFlights(
        location: String,
        destination: String,
        departure: String,
        returnDate: String,
        passport: String,
    ): Result<BookingBodyDomain>

//    suspend fun fetchBookingById(objectId: String): Result<BookingDomain>


}