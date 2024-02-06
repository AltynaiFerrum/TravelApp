package com.jyldyzferr.travelapp.presentation.screens.main.see_all_screen

import com.jyldyzferr.travelapp.presentation.navigations.Destination


object SeeAllScreenDestination: Destination {
    override fun route(): String = "see_all_screen_route"

    override fun routeWithArgs(): String = route()
}