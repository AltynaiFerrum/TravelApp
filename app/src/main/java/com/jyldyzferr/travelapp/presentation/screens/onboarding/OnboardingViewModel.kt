package com.jyldyzferr.travelapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.domain.usecases.current_user.SetOnboardingShowedUseCase
import com.jyldyzferr.travelapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val setOnboardingShowedUserCase: SetOnboardingShowedUseCase,
    private val navigationManager: NavigatorManager
) : ViewModel() {

    private val _navControllerFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navControllerFlow: SharedFlow<String> = _navControllerFlow.asSharedFlow()

    fun onboardingFinished() {
        setOnboardingShowedUserCase()
        _navControllerFlow.tryEmit(SignInDestination.route())
    }
}