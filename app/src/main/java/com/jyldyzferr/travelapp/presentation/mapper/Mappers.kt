package com.jyldyzferr.travelapp.presentation.mapper

import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.presentation.models.Booking


fun BookingDomain.toBooking() = this.run {
    if (this == BookingDomain.unknown) return@run Booking.unknown
    Booking(
        objectId = objectId,
        updatedAt = updatedAt,
        location = location,
        destination = destination,
        departure = departure,
        returnDate = returnDate,
//        money = money,
        passport = passport
    )
}


fun Booking.toBookingUi(): BookingBasketDomain =
    BookingBasketDomain(
        departure = departure,
        destination = destination,
        location = location,
        passport = passport,
        returnDate = returnDate
    )


