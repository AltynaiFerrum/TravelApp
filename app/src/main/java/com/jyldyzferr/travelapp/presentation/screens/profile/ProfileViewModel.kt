package com.jyldyzferr.travelapp.presentation.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.jyldyzferr.travelapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.models.toUser
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EDIT_PROFILE_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()


    init {
        _uiState.tryEmit(ProfileUiState.Loading)
        try {
            val user = fetchCurrentUserUseCase().toUser()
            _uiState.tryEmit(ProfileUiState.Content(user))
            Log.i("Profile", "name = ${user.name}")
        } catch (e: Exception) {
            val errorState = ProfileUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
        }
    }


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditProfile -> navigateToEditProfileScreen()
            is ProfileEvent.OnEditBackgroundImage -> {}
            is ProfileEvent.OnLogOut -> logout()
        }
    }

    private fun navigateToEditProfileScreen() {
        _navCommandFlow.tryEmit(EDIT_PROFILE_ROUTE)
    }

    private fun logout() {

    }
}