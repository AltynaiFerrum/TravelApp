package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import com.jyldyzferr.travelapp.domain.repositories.CurrentBookingRepository
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

interface CurrentBookingUseCase {
    suspend operator fun invoke(booking: BookingDomain)
}


class CurrentBookingUseCaseImpl(
    private val repository: CurrentBookingRepository
) : CurrentBookingUseCase {
    override suspend fun invoke(booking: BookingDomain) {
        return repository.saveCurrentBooking(booking)
    }

}

