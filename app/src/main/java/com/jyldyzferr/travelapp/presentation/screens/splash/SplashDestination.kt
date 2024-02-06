package com.jyldyzferr.travelapp.presentation.screens.splash

import com.jyldyzferr.travelapp.presentation.navigations.Destination

object SplashDestination: Destination {
    override fun route(): String = "splash_screen_route"

    override fun routeWithArgs(): String = route()
}