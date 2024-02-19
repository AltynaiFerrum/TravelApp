package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import com.jyldyzferr.travelapp.domain.repositories.UserRepository

class BookingFlightUseCaseImpl constructor(
    private val repository: BookingRepository,

) : BookingFlightUseCase {
    override suspend fun bookingFlight(booking: BookingBasketDomain) {
        return repository.bookingFlights(booking)
    }
}


