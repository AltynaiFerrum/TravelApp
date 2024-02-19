package com.jyldyzferr.travelapp.data.cloud.service

import com.jyldyzferr.travelapp.data.cloud.models.CreateResponse
import com.jyldyzferr.travelapp.data.cloud.models.SignUpParams
import com.jyldyzferr.travelapp.data.cloud.models.UserResponse
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingBody
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingCloud
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingParams
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BookingService {
    @GET("Booking")
    suspend fun boardingPass(): Response<BookingResponse>

    @POST("Booking")
    suspend fun bookingFlights(
        @Body params: BookingParams
    ): Response<BookingBody>

    @GET("Booking")
    suspend fun fetchBookingById(
        @Query("where") query: String
    ): Response<BookingResponse>
}