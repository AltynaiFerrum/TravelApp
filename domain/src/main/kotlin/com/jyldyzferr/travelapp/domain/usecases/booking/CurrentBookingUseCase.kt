package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository

interface CurrentBookingUseCase {
    suspend operator fun invoke(objectId: String): Result<BookingDomain>
}


class CurrentBookingUseCaseImpl(
    private val repository: BookingRepository
) : CurrentBookingUseCase {
    override suspend fun invoke(objectId: String): Result<BookingDomain> {
        return repository.fetchBookingById(objectId)
    }
}