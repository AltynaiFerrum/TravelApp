package com.jyldyzferr.travelapp.presentation.screens.splash

interface SplashScreenActions {
    fun navigateToOnboardingScreen()

    fun navigateToLoginScreen()

    fun navigateToMainScreen()

    object Preview: SplashScreenActions{
        override fun navigateToOnboardingScreen() = Unit
        override fun navigateToLoginScreen() = Unit
        override fun navigateToMainScreen() = Unit
    }
}