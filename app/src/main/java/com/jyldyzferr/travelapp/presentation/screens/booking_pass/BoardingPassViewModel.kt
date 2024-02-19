package com.jyldyzferr.travelapp.presentation.screens.booking_pass

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.domain.usecases.booking.CurrentBookingUseCase
import com.jyldyzferr.travelapp.domain.usecases.booking.FetchBookingOrderUseCase
import com.jyldyzferr.travelapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.jyldyzferr.travelapp.presentation.models.toBooking
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class BoardingPassViewModel @Inject constructor(
    private val fetchBookingOrderUseCase: CurrentBookingUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<BoardingPassUiState>(BoardingPassUiState.Initial)
    val uiState: StateFlow<BoardingPassUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()


    init {
        _uiState.tryEmit(BoardingPassUiState.Loading)
        try {
            val booking = fetchBookingOrderUseCase().toBooking()
            _uiState.tryEmit(BoardingPassUiState.Content(booking))
            Log.i("Profile", "name = ${booking.departure}")
        } catch (e: Exception) {
            val errorState = BoardingPassUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
        }
    }
}