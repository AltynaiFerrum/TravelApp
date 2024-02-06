package com.jyldyzferr.travelapp.presentation.screens.auth.sign_in

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.jyldyzferr.travelapp.domain.usecases.sign_in.SignInUseCase
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.managers.toast.ShowToastUseCase
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.auth.password_reset.PasswordResetDestination
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

val default_error_message = "Something went wrong!"

@HiltViewModel
class SignInScreenViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val saveCurrentUserUseCase: SaveCurrentUserUseCase,
    private val showToastUseCase: ShowToastUseCase,
    private val navigatorManager: NavigatorManager,

    ) : ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnEmailChanged -> doEmailChanged(event)
            is SignInEvent.OnPasswordChanged -> doPasswordChanged(event)
            is SignInEvent.OnSignUpClick -> doSignUpClick()
            is SignInEvent.OnLoginClick -> doLoginClick()
            is SignInEvent.OnResetPasswordClick -> doResetPasswordClick()
        }
    }

    private fun doLoginClick() {
        _uiState.update { currentState ->
            currentState.copy(isAuthentication = true)
        }
        val email = _uiState.value.email
        val password = _uiState.value.password
        viewModelScope.launch {
            val result = signInUseCase(
                email = email, password = password
            )
            handleLoginResult(result)
        }
    }

    private fun handleLoginResult(
        result: Result<UserDomain>
    ) {
        when (result) {
            is Result.Error -> {
                showToastUseCase.showToast(result.message ?: default_error_message)
                Log.e("TravelApp", "message = $(result.message}")
            }
            is Result.Success -> {
                Log.e("TravelApp", "data = $(result.data}")
                val user = result.data
                if (user == null) {
                    showToastUseCase.showToast(result.message ?: default_error_message)
                    return
                }
                saveCurrentUserUseCase(user)
                navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE)
            }
        }
        _uiState.update { currentState ->
            currentState.copy(isAuthentication = false)
        }
    }

    private fun doSignUpClick() {
        _uiState.update { currentState ->
            currentState.copy(isSuccessesAuth = true)
        }
        navigatorManager.navigateTo(AUTH_NAV_GRAPH_ROUTE)
    }

    private fun doPasswordChanged(
        event: SignInEvent.OnPasswordChanged
    ) {
        _uiState.update { currentState ->
            currentState.copy(password = event.value)
        }
    }

    private fun doEmailChanged(
        event: SignInEvent.OnEmailChanged
    ) {
        _uiState.update { currentState ->
            currentState.copy(email = event.value)
        }
    }

    private fun doResetPasswordClick(){
//        _uiState.update { currentState ->
//            currentState.copy(isSuccessesAuth = true)
//        }
        navigatorManager.navigateTo(PasswordResetDestination.route())
    }
}
