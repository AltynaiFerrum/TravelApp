package com.jyldyzferr.travelapp.presentation.screens.auth.password_reset

import com.jyldyzferr.travelapp.presentation.navigations.Destination


object PasswordResetDestination: Destination {
    override fun route(): String = "password_reset_screen_route"

    override fun routeWithArgs(): String = route()
}