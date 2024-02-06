package com.jyldyzferr.travelapp.presentation.screens.main

import com.jyldyzferr.travelapp.presentation.models.Tour


sealed class MainUiState {

    data object Initial: MainUiState()

    data object Loading: MainUiState()

    data class Error(val message: String): MainUiState()

    data class Content (
        val tour: List<Tour>
    ): MainUiState()
}



