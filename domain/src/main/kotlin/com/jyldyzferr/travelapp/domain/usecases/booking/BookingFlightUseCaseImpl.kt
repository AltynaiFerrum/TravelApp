package com.jyldyzferr.travelapp.domain.usecases.booking

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingBodyDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import com.jyldyzferr.travelapp.domain.repositories.CurrentBookingRepository
import com.jyldyzferr.travelapp.domain.repositories.UserRepository

class BookingFlightUseCaseImpl constructor(
    private val repository: BookingRepository,
    private val currentBookingRepository: CurrentBookingRepository

) : BookingFlightUseCase {
    //    override suspend fun bookingFlight(booking: BookingBasketDomain) {
//        return repository.bookingFlights(booking)
//    }
    override suspend fun invoke(
        location: String,
        destination: String,
        departure: String,
        returnDate: String,
        passport: String
    ): Result<BookingDomain> {
        if (location.isEmpty()) {
            return Result.Error(message = "First fill in location!")
        }
        if (destination.isEmpty()) {
            return Result.Error(message = "First fill in destination!")
        }

//        if (email.isEmpty()) {
//            return Result.Error(message = "First fill in email!")
//        }
        if (departure.isEmpty()) {
            return Result.Error(message = "First fill in departure!")
        }

        if (returnDate.isEmpty()) {
            return Result.Error(message = "Incorrect fill returnDate")
        }
        if (passport.isEmpty()) {
            return Result.Error(message = "Incorrect fill passport")
        }

        val response = repository.bookingFlights(
            location = location,
            destination = destination,
            departure = departure,
            returnDate = returnDate,
            passport = passport
        )
//        return repository.bookingFlights(
//            location = location,
//            destination = destination,
//            departure =departure,
//            returnDate = returnDate,
//            passport = passport,
//        )
        return currentBookingRepository.fetchBookingById(response.data?.id ?: String())
    }
}



