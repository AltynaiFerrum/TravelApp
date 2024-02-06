//package com.jyldyzferr.travelapp.presentation.navigation
//
//import androidx.compose.foundation.background
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ModalBottomSheetState
//import androidx.compose.material.ModalBottomSheetValue
//import androidx.compose.material.Surface
//import androidx.compose.material.rememberModalBottomSheetState
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.jyldyzferr.travelapp.data.fake_data.FakeData
//import com.jyldyzferr.travelapp.presentation.navigation.destinations.DetailsScreenDestination
//import com.jyldyzferr.travelapp.presentation.screens.details.DetailComponent
//import com.jyldyzferr.travelapp.presentation.screens.details.DetailsAboutTourScreen
//import com.jyldyzferr.travelapp.presentation.screens.details.DetailsScreenViewModel
//import com.jyldyzferr.travelapp.presentation.screens.main.see_all_screen.CategoryScreen
//import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileDestination
//import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileScreen
//import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileViewModel
//import com.jyldyzferr.travelapp.presentation.screens.favorite.FavoriteListViewModel
//import com.jyldyzferr.travelapp.presentation.screens.favorite.WishlistScreen
//import com.jyldyzferr.travelapp.presentation.screens.info.InfoScreen
//import com.jyldyzferr.travelapp.presentation.screens.main.HomeViewModel
//import com.jyldyzferr.travelapp.presentation.screens.main.LoadedMainScreen
//import com.jyldyzferr.travelapp.presentation.screens.main.MainScreen
//import com.jyldyzferr.travelapp.presentation.screens.main.MainToursViewModel
//import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchDestination
//import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchScreen
//import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchUiState
//import com.jyldyzferr.travelapp.presentation.screens.main.search.SearchViewModel
//import com.jyldyzferr.travelapp.presentation.screens.main.see_all_screen.SeeAllScreen
//import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileScreen
//import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileViewModel
//import com.jyldyzferr.travelapp.presentation.screens.main.see_all_screen.SeeAllScreenDestination
//import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun BottomNavGraph(
//    navController: NavHostController,
////    sheetState: ModalBottomSheetState,
//    modifier: Modifier = Modifier
//) {
//    var darkTheme by remember { mutableStateOf(false) }
//    TravelAppTheme(darkTheme = darkTheme) {
//        NavHost(
//            navController = navController,
//            startDestination = BottomBarNavigationDestinations.Main.route
//        ) {
//            composable(route = BottomBarNavigationDestinations.Main.route) {
//                val viewModel: MainToursViewModel = hiltViewModel()
//                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//                MainScreen(
//                    uiState = uiState,
//                    topRatedMovies = FakeData.fakeRecommendationsEvent().random(),
//                    navigateToDetails = { tourId ->
//                        navController.navigate("${DetailsScreenDestination.route()}/$tourId")
//                    },
//                    navigateToSeeAllScreen = {
//                        navController.navigate(SeeAllScreenDestination.route())
//                    },
//                    navigateToSearchScreen = {
//                        navController.navigate(SearchDestination.route())
//                    },
////                    sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
//                )
//            }
//            composable(route = SearchDestination.route()) {
//                val viewModelSearch: SearchViewModel = hiltViewModel()
//
//                SearchScreen(
//                    uiState = viewModelSearch.uiStateFlow.collectAsStateWithLifecycle().value,
//                    onValueChange = viewModelSearch::onValueChange
//                )
//            }
//            composable(route = SeeAllScreenDestination.route()) {
//                SeeAllScreen(
//                    popBackStack = navController::navigateUp,
//                )
//            }
//            composable(route = BottomBarNavigationDestinations.Favorite.route) {
//                val viewModel: FavoriteListViewModel = hiltViewModel()
//                WishlistScreen(
//                    popBackStack = navController::navigateUp,
//                    navigateToDetails = { tourId ->
//                        navController.navigate("${DetailsScreenDestination.route()}/$tourId")
//                    },
//                    uiStateFlow = viewModel.uiState
//                )
//            }
//            composable(route = BottomBarNavigationDestinations.Profile.route) {
//                val viewModel: ProfileViewModel = hiltViewModel()
//                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//                ProfileScreen(
//                    darkTheme = darkTheme,
//                    onThemeUpdated = { darkTheme = !darkTheme },
//                    onEvent = viewModel::onEvent,
//                    uiState = uiState,
//                    popBackStack = navController::navigateUp,
//                    navigateToEditScreen = {
//                        navController.navigate(EditProfileDestination.route())
//                    }
//                )
//            }
//            composable(route = EditProfileDestination.route()) {
//                val viewModel: EditProfileViewModel = hiltViewModel()
//                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
////                val uploadProgress by viewModel.uploadProgress.collectAsStateWithLifecycle()
//                EditProfileScreen(
//                    uiState = uiState,
//                    onEvent = viewModel::onEvent,
//                    popBackStack = navController::navigateUp,
////                    uploadProgress = uploadProgress
//                )
//            }
//            composable(route = BottomBarNavigationDestinations.Info.route) {
//                InfoScreen(
//                    text = "Share", context = LocalContext.current
//                )
//            }
//            composable(
//                route = DetailsScreenDestination.routeWithArgs(),
//                arguments = DetailsScreenDestination.arguments
//            ) { navBackStackEntry ->
//                val viewModel: DetailsScreenViewModel = hiltViewModel()
//                val tourId = navBackStackEntry
//                    .arguments
//                    ?.getString(DetailsScreenDestination.tourIdKey)
//                    ?: 0
//                DetailsAboutTourScreen(
//                    popBackStack = navController::navigateUp,
//                    addOrDeleteMovie = {
//                        viewModel.addOrDeleteTour(String())
//                    },
//                    uiState = viewModel.uiStateFlow.collectAsStateWithLifecycle().value,
//                )
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
