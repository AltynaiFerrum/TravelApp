package com.jyldyzferr.travelapp.presentation.screens.edit_profile

import android.graphics.Bitmap


sealed class EditProfileUiState {

    data object Initial: EditProfileUiState()

    data object Loading: EditProfileUiState()

    data class Error(val message: String) : EditProfileUiState()

    data class Content(
        val name: String,
        val lastName: String,
        val email: String,
    ) : EditProfileUiState()
}