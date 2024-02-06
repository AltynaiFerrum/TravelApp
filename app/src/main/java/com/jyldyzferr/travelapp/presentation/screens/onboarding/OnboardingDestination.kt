package com.jyldyzferr.travelapp.presentation.screens.onboarding

import com.jyldyzferr.travelapp.presentation.navigations.Destination


object OnboardingDestination: Destination {
    override fun route(): String = "onboarding_screen_route"

    override fun routeWithArgs(): String = route()
}