package com.jyldyzferr.travelapp.presentation.screens.auth.sign_up

import com.jyldyzferr.travelapp.presentation.navigations.Destination

object SignUpDestination: Destination {
    override fun route(): String = "sign_up_screen_route"

    override fun routeWithArgs(): String = route()
}