package com.jyldyzferr.travelapp.presentation.screens.auth.sign_in

import com.jyldyzferr.travelapp.presentation.navigations.Destination

object SignInDestination: Destination {
    override fun route(): String = "sign_in_screen_route"

    override fun routeWithArgs(): String = route()
}
