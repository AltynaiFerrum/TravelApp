package com.jyldyzferr.travelapp.presentation.navigations.navGraph


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jyldyzferr.travelapp.presentation.screens.auth.password_reset.PasswordResetDestination
import com.jyldyzferr.travelapp.presentation.screens.auth.password_reset.PasswordResetScreen
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInDestination
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInScreen
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInScreenViewModel
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpDestination
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpScreen
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpViewModel
import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingDestination
import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingScreen
import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingViewModel

const val AUTH_NAV_GRAPH_ROUTE = "auth_nav_graph_route"

@Composable
fun AuthNavGraphRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingDestination.route()
    ) {
        composable(OnboardingDestination.route()) {
            val viewModel: OnboardingViewModel = hiltViewModel()
            val navCommand by viewModel.navControllerFlow.collectAsStateWithLifecycle(
                initialValue = null
            )
            LaunchedEffect(key1 = navCommand) {
                if (navCommand != null) navController.navigate(navCommand!!)
            }
            OnboardingScreen(
                navigateToSignInScreen = {
                    viewModel.onboardingFinished()
                }
            )
        }
        composable(SignInDestination.route()) {
            val viewModel: SignInScreenViewModel = hiltViewModel()
            val navCommand by viewModel.navCommandFlow.collectAsStateWithLifecycle(
                initialValue = null
            )
            LaunchedEffect(key1 = navController){
                if (navCommand != null) navController.navigate(navCommand!!)
            }
            SignInScreen(
                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
                onEvent = viewModel::onEvent,
                navigateToPassword = {
                    navController.navigate(PasswordResetDestination.route())
                },
                navigateToSignUp = {
                    navController.navigate(SignUpDestination.route())
                }
            )
        }
        composable(PasswordResetDestination.route()) {
            PasswordResetScreen(
                popBackStack = navController::navigateUp,
                )
        }
        composable(SignUpDestination.route()) {
            val viewModel: SignUpViewModel = hiltViewModel()
            val navCommand by viewModel.navControllerFlow.collectAsStateWithLifecycle(
                initialValue = null
            )
            LaunchedEffect(key1 = navCommand) {
                if (navCommand != null) navController.navigate(navCommand!!)
            }
            SignUpScreen(
                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
                onEvent = viewModel::onEvent,
                popBackStack = navController::navigateUp,
            )
        }
    }
}