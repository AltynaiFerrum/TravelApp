package com.jyldyzferr.travelapp.domain.models

data class BookingBasketDomain(
    val departure: String,
    val destination: String,
    val location: String,
    val passport: String,
    val returnDate: String,
) : java.io.Serializable {
    companion object {
        val unknown = BookingBasketDomain(
            departure = String(),
            destination = String(),
            returnDate = String(),
            passport = String(),
            location = String()
        )
    }
}


