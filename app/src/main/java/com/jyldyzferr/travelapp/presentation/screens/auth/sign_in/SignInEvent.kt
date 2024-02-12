package com.jyldyzferr.travelapp.presentation.screens.auth.sign_in

sealed class SignInEvent {
    data class OnEmailChanged(val value: String) : SignInEvent()
    data class OnPasswordChanged(val value: String) : SignInEvent()
    data object OnSignUpClick: SignInEvent()
    data object OnResetPasswordClick: SignInEvent()
    data object OnLoginClick: SignInEvent()
}