package com.jyldyzferr.travelapp.presentation.screens.auth.sign_up

data class SignUpUiState(
    val name: String = String(),
    val email: String = String(),
    val lastName: String = String(),
    val password: String = String(),
    val isAuthentication: Boolean = false,
    val errorMessage: String? = null,
    val isSuccessesAuth: Boolean = false
)