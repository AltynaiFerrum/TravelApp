package com.jyldyzferr.travelapp.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.AuthNavGraphRoot
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MainNavGraphRoot
import com.jyldyzferr.travelapp.presentation.screens.splash.SplashDestination
import com.jyldyzferr.travelapp.presentation.screens.splash.SplashScreen
import com.jyldyzferr.travelapp.presentation.screens.splash.SplashScreenViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashDestination.route()
    ) {

        composable(SplashDestination.route()) {
            val viewModel: SplashScreenViewModel = hiltViewModel()
            viewModel
            SplashScreen()
        }
        composable(AUTH_NAV_GRAPH_ROUTE) {
            AuthNavGraphRoot()
        }
        composable(MAIN_NAV_GRAPH_ROUTE) {
            MainNavGraphRoot()
        }
    }
}