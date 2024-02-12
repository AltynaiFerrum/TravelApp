package com.jyldyzferr.travelapp.presentation.screens.details

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.jyldyzferr.travelapp.presentation.navigations.Destination

internal const val TOUR_ID = "tourId"
object DetailDestination : Destination {

    override fun route(): String = "tour_details_screen"

    override fun routeWithArgs(): String = "${route()}/{${TOUR_ID}}"

    val arguments = listOf(navArgument(TOUR_ID) { type = NavType.StringType })

}