package com.jyldyzferr.travelapp.presentation.screens.profile

import com.jyldyzferr.travelapp.presentation.models.User

sealed class ProfileUiState {

    data object Initial: ProfileUiState()

    data object Loading: ProfileUiState()

    data class Error(val message: String): ProfileUiState()

    data class Content (
        val user: User
    ): ProfileUiState()
}

