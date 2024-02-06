package com.jyldyzferr.travelapp.presentation.screens.main

import com.jyldyzferr.travelapp.presentation.navigations.Destination

object HomeDestination: Destination {
    override fun route(): String = "home_destination"

    override fun routeWithArgs(): String = route()
}