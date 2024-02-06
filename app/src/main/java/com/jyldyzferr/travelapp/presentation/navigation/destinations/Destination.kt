//package com.jyldyzferr.travelapp.presentation.navigation.destinations
//
//import androidx.navigation.NavType
//import androidx.navigation.navArgument
//
//
//interface Destination {
//    fun route(): String
//
//    fun routeWithArgs(): String
//}
//
//object MainScreenDestination : Destination {
//    override fun route(): String = "main_screen"
//
//    override fun routeWithArgs(): String = ""
//    }
//
//
//object DetailsScreenDestination : Destination {
//    val tourIdKey = "tourIdKey"
//    override fun route(): String = "detail_screen"
//
//    override fun routeWithArgs(): String ="${route()}/{$tourIdKey}"
//    val arguments = listOf(navArgument(tourIdKey){ type= NavType.StringType})
//}
