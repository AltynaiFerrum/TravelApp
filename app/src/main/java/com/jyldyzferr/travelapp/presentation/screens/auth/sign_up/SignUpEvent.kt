package com.jyldyzferr.travelapp.presentation.screens.auth.sign_up

sealed class SignUpEvent {

    data class OnNameChanged(val value: String) : SignUpEvent()
    data class OnEmailChanged(val value: String) : SignUpEvent()
    data class OnPasswordChanged(val value: String) : SignUpEvent()
    data class OnLastNameChanged(val value: String) : SignUpEvent()
    data object OnSignUpClick: SignUpEvent()
    data object OnLoginClick: SignUpEvent()
}