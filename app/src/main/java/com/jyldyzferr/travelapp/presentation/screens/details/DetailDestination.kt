package com.jyldyzferr.travelapp.presentation.screens.details

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.jyldyzferr.travelapp.presentation.navigations.Destination

//interface DetailDestination {
//
//    val route: String
//    val routeWithArgs: String
//
//}
//
//object DetailsScreenDestination : DetailDestination {
//    const val tourId = "tourId"
//    const val abroadId = "abroadId"
//    override val route: String = "detail_screen"
//    override val routeWithArgs = "$route/{$tourId}/{$abroadId}"
//    val arguments = listOf(navArgument(tourId) { type = NavType.StringType })
//}

internal const val TOUR_ID = "tourId"
internal const val ABROAD_ID = "abroadId"
object DetailDestination : Destination {

    override fun route(): String = "tour_details_screen"

    override fun routeWithArgs(): String = "${route()}/{${TOUR_ID}}"

    val arguments = listOf(navArgument(TOUR_ID) { type = NavType.StringType })

}