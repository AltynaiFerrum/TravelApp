package com.jyldyzferr.travelapp.presentation.screens.favorite

import com.jyldyzferr.travelapp.domain.models.ToursNewDomain

sealed class WishlistUiState {

    data object Loading : WishlistUiState()

    data class Loaded(
        val tours: List<ToursNewDomain> = emptyList()
    ) : WishlistUiState()

    data class Error(
        val message: String
    ) : WishlistUiState()

}


