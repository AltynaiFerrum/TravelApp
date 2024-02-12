package com.jyldyzferr.travelapp.presentation.navigations.navGraph

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jyldyzferr.travelapp.presentation.navigations.AppBottomNavigation
import com.jyldyzferr.travelapp.presentation.navigations.BottomBarNavigationDestinations
import com.jyldyzferr.travelapp.presentation.screens.details.DetailDestination
import com.jyldyzferr.travelapp.presentation.screens.details.DetailsAboutTourScreen
import com.jyldyzferr.travelapp.presentation.screens.details.DetailsScreenViewModel
import com.jyldyzferr.travelapp.presentation.screens.details.TOUR_ID
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EDIT_PROFILE_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileDestination
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileScreen
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileViewModel
import com.jyldyzferr.travelapp.presentation.screens.favorite.FavoriteListViewModel
import com.jyldyzferr.travelapp.presentation.screens.favorite.WishlistScreen
import com.jyldyzferr.travelapp.presentation.screens.info.InfoScreen
import com.jyldyzferr.travelapp.presentation.screens.main.MainScreenSecond
import com.jyldyzferr.travelapp.presentation.screens.main.MainToursViewModel
import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchDestination
import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchScreen
import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchViewModel
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileScreen
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileViewModel
import com.jyldyzferr.travelapp.presentation.screens.profile.premium.ListScreenViewModel
import com.jyldyzferr.travelapp.presentation.screens.profile.premium.PREMIUM_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.profile.premium.PremiumScreen
import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme

const val MAIN_NAV_GRAPH_ROUTE = "main_nav_graph_route"

@Composable
fun MainNavGraphRoot(
    modifier: Modifier = Modifier
) {
    var darkTheme by remember { mutableStateOf(false) }
    TravelAppTheme(darkTheme = darkTheme) {

        val navHostController = rememberNavController()
        Scaffold(
            bottomBar = {
                AppBottomNavigation(
                    navController = navHostController,
                )
            }
        ) { innerPaddings ->
            NavHost(
                modifier = Modifier
                    .padding(innerPaddings),
                navController = navHostController,
                startDestination = BottomBarNavigationDestinations.MAIN.route
            ) {
                composable(BottomBarNavigationDestinations.MAIN.route) {
                    val viewModel: MainToursViewModel = hiltViewModel()
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    MainScreenSecond(
                        uiState = uiState,
                        navigateToDetails = { tourId ->
                            navHostController.navigate("${DetailDestination.route()}/$tourId")
                        },
                        navigateToSearchScreen = {
                            navHostController.navigate(SearchDestination.route())
                        },
                    )
                }
                composable(route = SearchDestination.route()) {
                    val viewModelSearch: SearchViewModel = hiltViewModel()
                    val uiState by viewModelSearch.uiState.collectAsStateWithLifecycle()
                    SearchScreen(
                        uiState = uiState,
                        onValueChange = viewModelSearch::onValueChange,
                        navigateToDetails = { tourId ->
                            navHostController.navigate("${DetailDestination.route()}/$tourId")
                        }
                    )
                }
                composable(route = BottomBarNavigationDestinations.FAVORITE.route) {
                    val viewModel: FavoriteListViewModel = hiltViewModel()
                    WishlistScreen(
                        uiStateFlow = viewModel.uiState,
                        popBackStack = navHostController::navigateUp,
                        navigateToDetails = { tourId ->
                            navHostController.navigate("${DetailDestination.route()}/$tourId")
                        },
                    )
                }
                composable(route = BottomBarNavigationDestinations.PROFILE.route) {
                    val viewModel: ProfileViewModel = hiltViewModel()
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    val navCommand by viewModel.navCommandFlow.collectAsStateWithLifecycle(initialValue = null)

                    LaunchedEffect(key1 = navCommand) {
                        if (navCommand != null) navHostController.navigate(navCommand!!)
                    }
                    ProfileScreen(
                        darkTheme = darkTheme,
                        onThemeUpdated = { darkTheme = !darkTheme },
                        onEvent = viewModel::onEvent,
                        uiState = uiState,
                        popBackStack = navHostController::navigateUp,
                        navigateToSignIn = {
                            navHostController.navigate(AUTH_NAV_GRAPH_ROUTE)
                        },
                        navigateToPremiumScreen = {
                            navHostController.navigate(PREMIUM_ROUTE)
                        }
                    )
                }
                composable(PREMIUM_ROUTE) {
                    val viewModel: ListScreenViewModel = ListScreenViewModel()
                    PremiumScreen(
                        ListScreenViewModel()
                    )
                }
                composable(EDIT_PROFILE_ROUTE) {
                    val viewModel: EditProfileViewModel = hiltViewModel()
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    val uploadProgress by viewModel.uploadProgress.collectAsStateWithLifecycle()

                    EditProfileScreen(
                        uiState = uiState,
                        onEvent = viewModel::onEvent,
                        popBackStack = navHostController::navigateUp,
                        uploadProgress = uploadProgress,
                    )
                }
                composable(route = BottomBarNavigationDestinations.INFO.route) {
                    InfoScreen(
                        text = "Share", context = LocalContext.current
                    )
                }
                composable(
                    route = DetailDestination.routeWithArgs(),
                    arguments = DetailDestination.arguments
                ) { navBackStackEntry ->
                    val tourId =
                        navBackStackEntry.arguments?.getString(TOUR_ID)
                            ?: String()
                    val viewModel: DetailsScreenViewModel = hiltViewModel()
                    DetailsAboutTourScreen(
                        uiStateFlow = viewModel.uiState,
                        popBackStack = navHostController::navigateUp,
                        navigateToInfoScreen = {
                            navHostController.navigate(BottomBarNavigationDestinations.INFO.route)
                        },
                        fetchTour = {
                            viewModel.init(tourId)
                        },
                        addOrDeleteMovie = {
                            viewModel.addOrDeleteTour(tourId)
                        },
                    )
                }
            }
        }
    }
}




