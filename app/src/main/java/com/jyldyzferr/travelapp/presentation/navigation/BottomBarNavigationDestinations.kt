//package com.jyldyzferr.travelapp.presentation.navigation
//
//import androidx.annotation.DrawableRes
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Info
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.ui.graphics.vector.ImageVector
//import com.jyldyzferr.travelapp.R
//
//sealed class BottomBarNavigationDestinations(
//    val route: String,
//    val title: String,
//    val icon: ImageVector,
//    val hasBadge: Boolean,
//    val messages: Int
//
//    ) {
//    object Main : BottomBarNavigationDestinations(
//        route = "main",
//        title = "Home",
//        icon = Icons.Default.Home,
//        hasBadge = false,
//        messages = 12
//    )
//
//    object Favorite : BottomBarNavigationDestinations(
//        route = "favorite",
//        title = "Favorite",
//        icon = Icons.Default.Favorite,
//        hasBadge = false,
//        messages = 0
//    )
//
//    object Profile : BottomBarNavigationDestinations(
//        route = "profile",
//        title = "Profile",
//        icon = Icons.Default.Person,
//        hasBadge = false,
//        messages = 0
//    )
//
//    object Info : BottomBarNavigationDestinations(
//        route = "info",
//        title = "Info",
//        icon = Icons.Default.Info,
//        hasBadge = false,
//        messages = 0
//    )
//}