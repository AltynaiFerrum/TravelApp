package com.jyldyzferr.travelapp.presentation.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.models.toUser
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EDIT_PROFILE_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.edit_profile.EditProfileDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class  ProfileViewModel @Inject constructor(
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase,
    private val navigatorManager: NavigatorManager,
    ) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        _uiState.tryEmit(ProfileUiState.Loading)
        try {
            val user = fetchCurrentUserUseCase().toUser()
            _uiState.tryEmit(ProfileUiState.Content(user))
            Log.i("Profile", "name = ${user.name}")
        } catch (e: Exception){
            val errorState = ProfileUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
        }
//        val state = ProfileUiState.Content(
//            user = User.unknown.copy(
//                imageCloud = "https://images.unsplash.com/photo-1588508065123-287b28e013da?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80",
//                avatar = "https://wallpapers.com/images/hd/abstract-light-blue-color-hd-741ceqmu8dr8w2gt.jpg",
//            )
//        )
//        _uiState.tryEmit(state)
    }


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditProfile -> navigateToEditProfileScreen()
            is ProfileEvent.OnEditBackgroundImage -> {}
            is ProfileEvent.OnLogOut -> logout()
        }
    }

    private fun navigateToEditProfileScreen(){
//        navigatorManager.navigateTo(EditProfileDestination.route())
    }

    private fun logout(){

    }
}