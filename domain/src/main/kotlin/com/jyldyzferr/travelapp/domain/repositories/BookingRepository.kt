package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain

interface BookingRepository {
    suspend fun boardingPass(): Result<List<BookingDomain>>

    suspend fun bookingFlights(booking: BookingBasketDomain)

    suspend fun fetchBookingById(objectId: String): Result<BookingDomain>


}