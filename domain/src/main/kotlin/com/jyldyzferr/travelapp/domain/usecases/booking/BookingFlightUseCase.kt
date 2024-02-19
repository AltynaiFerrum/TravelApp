package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain

interface BookingFlightUseCase {

    suspend fun bookingFlight(booking: BookingBasketDomain)
}