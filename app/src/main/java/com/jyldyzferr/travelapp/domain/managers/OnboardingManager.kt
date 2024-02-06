package com.jyldyzferr.travelapp.domain.managers

interface OnboardingManager {

    fun isOnboardingPassed(): Boolean

    fun setOnboardingShowed()

    fun clearOnboarding()
}