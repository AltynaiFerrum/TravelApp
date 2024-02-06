//package com.jyldyzferr.travelapp.presentation.navigation
//
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ModalBottomSheetState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInDestination
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInScreen
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpScreen
//import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingDestination
//import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingScreen
//import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingViewModel
//import com.jyldyzferr.travelapp.presentation.screens.splash.SplashDestination
//import com.jyldyzferr.travelapp.presentation.screens.splash.SplashScreen
//import com.jyldyzferr.travelapp.presentation.screens.splash.SplashViewModel
//import com.jyldyzferr.travelapp.presentation.navigation.destinations.MainScreenDestination
//import com.jyldyzferr.travelapp.presentation.screens.auth.password_reset.PasswordResetDestination
//import com.jyldyzferr.travelapp.presentation.screens.auth.password_reset.PasswordResetScreen
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInScreenViewModel
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpDestination
//import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpViewModel
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun AppNavGraph(
////    sheetState: ModalBottomSheetState,
//    navHostController: NavHostController,
//) {
//    NavHost(
//        navController = navHostController,
//        startDestination = SplashDestination.route()
//    ) {
//        composable(SplashDestination.route()) {
//            val viewModel: SplashViewModel = hiltViewModel()
//            SplashScreen(
//                uiState = viewModel.uiStateFlow.collectAsState().value,
//                actions = viewModel
//            )
//        }
//        composable(OnboardingDestination.route()) {
//            val viewModel: OnboardingViewModel = hiltViewModel()
//            OnboardingScreen(
//                navigateToSignInScreen = {
//                    navHostController.navigate(SignInDestination.route())
//                }
//            )
//        }
//        composable(SignInDestination.route()) {
//            val viewModel: SignInScreenViewModel = hiltViewModel()
//            SignInScreen(
//                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
//                onEvent = viewModel::onEvent
//            )
//        }
//        composable(PasswordResetDestination.route()) {
//            PasswordResetScreen()
//        }
//        composable(SignUpDestination.route()) {
//            val viewModel: SignUpViewModel = hiltViewModel()
//            SignUpScreen(
//                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
//                onEvent = viewModel::onEvent,
//                popBackStack = navHostController::navigateUp,
//            )
//        }
//        composable(
//            route = MainScreenDestination.route())
//        {
//            MainRootScreen(
////               sheetState = sheetState
//            )
//        }
//    }
//}
//
//
//
