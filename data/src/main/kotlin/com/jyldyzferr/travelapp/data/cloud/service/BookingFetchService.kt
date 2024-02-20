package com.jyldyzferr.travelapp.data.cloud.service

import com.jyldyzferr.travelapp.data.cloud.models.UserResponse
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookingFetchService {
    @GET("Booking")
    suspend fun fetchBookingById(
        @Query("where") params: String,
    ): BookingResponse

    @GET("Booking")
    suspend fun fetchAllBooking(): BookingResponse
}