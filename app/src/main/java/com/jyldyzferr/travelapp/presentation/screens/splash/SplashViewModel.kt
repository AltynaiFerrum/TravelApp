package com.jyldyzferr.travelapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.AUTH_NAV_GRAPH_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class SplashViewModel  @Inject constructor(
//    private val onboardingManager: OnboardingManager,
//    private val navigatorManager: NavigatorManager
//): ViewModel(), SplashScreenActions {
//
//    private val _uiStateFlow = MutableStateFlow(SplashUiState())
//    val uiStateFlow: StateFlow<SplashUiState> = _uiStateFlow.asStateFlow()
//
//    private val uiState = _uiStateFlow.value
//
//    init {
//        val isOnboardingPassed = onboardingManager.isOnboardingPassed()
//        _uiStateFlow.tryEmit(uiState.copy(isOnboardingPassed = isOnboardingPassed))
//    }
//
//    override fun navigateToOnboardingScreen() {
//        navigatorManager.navigateTo(OnboardingDestination.route())
//    }
//
//    override fun navigateToLoginScreen() {
//
//    }
//
//    override fun navigateToMainScreen() {
//
//    }
//}

private const val SPLASH_DELAY_TIME = 3_000L

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager,
//    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase,
//    private val onboardingPassedUseCase: IsOnboardingPassedUseCase

) : ViewModel() {

    init {
//        val currentUser = fetchCurrentUserUseCase().toUser()
//        val isOnboardingPassed = onboardingPassedUseCase()
        viewModelScope.launch {
            delay(SPLASH_DELAY_TIME)
//            val destination = when {
//                currentUser.isNotUnknown() -> MAIN_NAV_GRAPH_ROUTE
//                isOnboardingPassed -> MAIN_NAV_GRAPH_ROUTE
//                else -> MAIN_NAV_GRAPH_ROUTE
//            }
            navigatorManager.navigateTo(AUTH_NAV_GRAPH_ROUTE)
        }
    }
}