package com.jyldyzferr.travelapp.presentation.screens.auth.sign_in


data class SignInUiState(
    val email: String = String(),
    val password: String = String(),
    val isAuthentication: Boolean = false,
    val errorMessage: String? = null,
    val isSuccessesAuth: Boolean = false
)