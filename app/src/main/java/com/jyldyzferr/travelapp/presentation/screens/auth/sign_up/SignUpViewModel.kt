package com.jyldyzferr.travelapp.presentation.screens.auth.sign_up

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.jyldyzferr.travelapp.domain.usecases.sign_up.SignUpUseCase
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.managers.toast.ShowToastUseCase
import com.jyldyzferr.travelapp.presentation.navigations.BottomBarNavigationDestinations
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.default_error_message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val saveCurrentUserUseCase: SaveCurrentUserUseCase,
    private val showToastUseCase: ShowToastUseCase,
    private val navigatorManager: NavigatorManager,

    ) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnEmailChanged -> doEmailChanged(event)
            is SignUpEvent.OnPasswordChanged -> doPasswordChanged(event)
            is SignUpEvent.OnNameChanged -> doNameClick(event)
            is SignUpEvent.OnLastNameChanged -> doLastNameClick(event)
            is SignUpEvent.OnSignUpClick -> doSignUpClick()
            is SignUpEvent.OnLoginClick -> doLoginClick()
        }
    }
    private fun doPasswordChanged(event: SignUpEvent.OnPasswordChanged) {
        _uiState.update { currentState ->
            currentState.copy(password = event.value)
        }
    }

    private fun doEmailChanged(event: SignUpEvent.OnEmailChanged) {
        _uiState.update { currentState ->
            currentState.copy(email = event.value)
        }
    }

    private fun doNameClick(event: SignUpEvent.OnNameChanged) {
        _uiState.update { currentState ->
            currentState.copy(name = event.value)
        }
    }
    private fun doLastNameClick(event: SignUpEvent.OnLastNameChanged) {
        _uiState.update { currentState ->
            currentState.copy(lastName = event.value)
        }
    }

    private fun doSignUpClick() {
        viewModelScope.launch {
            val result = signUpUseCase(
                name = uiState.value.name,
                email = uiState.value.email,
                password = uiState.value.password,
                lastName = uiState.value.lastName
            )
            when(result){
                is Result.Error -> {
                    showToastUseCase.showToast(result.message ?: default_error_message)
                    Log.e("TravelApp", "message = ${result.message}")
                }
                is Result.Success -> {
                    val user = result.data ?: return@launch
                    saveCurrentUserUseCase(user)
                    navigatorManager.navigateTo(BottomBarNavigationDestinations.MAIN.route)
                    Log.e("TravelApp", "data = ${result.data}")
                }
            }
        }
    }
    private fun doLoginClick() {
        navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE)
    }
}