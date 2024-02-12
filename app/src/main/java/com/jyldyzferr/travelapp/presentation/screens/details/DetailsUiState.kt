package com.jyldyzferr.travelapp.presentation.screens.details

import com.jyldyzferr.travelapp.presentation.models.Tour

sealed class DetailsUiState {

    data object Initial : DetailsUiState()

    data object Loading : DetailsUiState()

    data class Error(val message: String) : DetailsUiState()

    data class Content(
        val tour: Tour,
        val isSaved: Boolean = false
    ) : DetailsUiState()
}
