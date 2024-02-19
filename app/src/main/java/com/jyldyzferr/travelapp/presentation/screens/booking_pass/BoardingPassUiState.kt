package com.jyldyzferr.travelapp.presentation.screens.booking_pass

import com.jyldyzferr.travelapp.presentation.models.Booking
import com.jyldyzferr.travelapp.presentation.models.User


sealed class BoardingPassUiState {

    data object Initial: BoardingPassUiState()

    data object Loading: BoardingPassUiState()

    data class Error(val message: String): BoardingPassUiState()

    data class Content (
        val booking: Booking
    ): BoardingPassUiState()
}

