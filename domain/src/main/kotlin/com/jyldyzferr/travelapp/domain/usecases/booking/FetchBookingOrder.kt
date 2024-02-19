package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import com.jyldyzferr.travelapp.domain.repositories.TourRepository


interface FetchBookingOrderUseCase {
    suspend fun boardingPass(): Result<List<BookingDomain>>
}

class FetchBookingOrderUseCaseImpl constructor(
    private val bookingRepository: BookingRepository,
):FetchBookingOrderUseCase{
    override suspend fun boardingPass(): Result<List<BookingDomain>> {
        return bookingRepository.boardingPass()
    }

}




