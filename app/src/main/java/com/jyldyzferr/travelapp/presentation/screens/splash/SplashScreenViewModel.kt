package com.jyldyzferr.travelapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.ShouldOnboardingPassedUseCase
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.models.toUser
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInDestination
import com.jyldyzferr.travelapp.presentation.screens.onboarding.OnboardingDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val SPLASH_DELAY_TIME = 3_000L

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager,
    private val fetchCurrentUserCase: FetchCurrentUserUseCase,
    private val shouldOnboardingPassedUseCase: ShouldOnboardingPassedUseCase

) : ViewModel() {
    init {
        val currentUser = fetchCurrentUserCase().toUser()
        val isOnBoardingPassed = shouldOnboardingPassedUseCase()
        viewModelScope.launch {
            delay(SPLASH_DELAY_TIME)
            val destination = when {
                currentUser.isNotUnknown() -> MAIN_NAV_GRAPH_ROUTE
                isOnBoardingPassed -> MAIN_NAV_GRAPH_ROUTE
                else -> AUTH_NAV_GRAPH_ROUTE
            }
            navigatorManager.navigateTo(destination, true)
        }
    }
}