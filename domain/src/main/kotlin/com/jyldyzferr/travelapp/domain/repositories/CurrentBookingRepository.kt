package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain

interface CurrentBookingRepository {
    suspend fun fetchBookingById(id: String): Result<BookingDomain>
    suspend fun fetchAllBooking(): Result<List<BookingDomain>>

    fun saveCurrentBooking(booking: BookingDomain)

}