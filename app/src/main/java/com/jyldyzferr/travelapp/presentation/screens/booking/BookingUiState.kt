package com.jyldyzferr.travelapp.presentation.screens.booking

import com.jyldyzferr.travelapp.presentation.models.Booking
import javax.annotation.concurrent.Immutable

data class BookingUiState(

    val addToBasket: Booking = Booking.unknown,
    val fetchFromBasket: List<Booking> = emptyList(),
    val error: String = "",


    val location: String = String(),
    val destination: String = String(),
    val departure: String = String(),
    val returnDate: String = String(),
    val passport: String = String(),
//    val createAt: String = String(),
//    val money: String = String(),
//    val isAuthentication: Boolean = false,
    val errorMessage: String? = null,
    val isSuccessesBooking: Boolean = false
)