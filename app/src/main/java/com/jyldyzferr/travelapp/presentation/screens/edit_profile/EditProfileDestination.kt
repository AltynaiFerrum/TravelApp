package com.jyldyzferr.travelapp.presentation.screens.edit_profile

import com.jyldyzferr.travelapp.presentation.navigations.Destination


object EditProfileDestination: Destination {
    override fun route(): String = "edit_profile_screen_route"

    override fun routeWithArgs(): String = route()
}