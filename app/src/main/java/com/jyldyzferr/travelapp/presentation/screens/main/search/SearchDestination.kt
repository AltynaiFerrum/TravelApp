package com.jyldyzferr.travelapp.presentation.screens.main.search

import com.jyldyzferr.travelapp.presentation.navigations.Destination


object SearchDestination: Destination {
    override fun route(): String = "search_destination"

    override fun routeWithArgs(): String = route()
}