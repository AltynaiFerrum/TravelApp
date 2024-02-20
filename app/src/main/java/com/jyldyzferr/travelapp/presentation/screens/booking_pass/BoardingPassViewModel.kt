package com.jyldyzferr.travelapp.presentation.screens.booking_pass

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.usecases.booking.CurrentBookingUseCase
import com.jyldyzferr.travelapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.jyldyzferr.travelapp.presentation.models.toUser
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BoardingPassViewModel @Inject constructor(
    private val fetchBookingOrderUseCase: CurrentBookingUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<BoardingPassUiState>(BoardingPassUiState.Initial)
    val uiState: StateFlow<BoardingPassUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiState.tryEmit(BoardingPassUiState.Error(throwable.localizedMessage ?: ""))
    }

//    fun init(bookingId: String) {
//        viewModelScope.launch(handler + Dispatchers.IO) {
//            fetchBookingById(bookingId)
//        }
//    }

//    init {
//        _uiState.tryEmit(BoardingPassUiState.Loading)
//        try {
//            val user = fetchBookingOrderUseCase()
//            _uiState.tryEmit(BoardingPassUiState.Content(user))
//            Log.i("Profile", "name = ${user.name}")
//        } catch (e: Exception) {
//            val errorState = BoardingPassUiState.Error(e.stackTraceToString())
//            _uiState.tryEmit(errorState)
//        }
//    }

//    private fun fetchBookingById(bookingId: String) {
//        viewModelScope.launch(handler + Dispatchers.IO) {
//            _uiState.tryEmit(BoardingPassUiState.Loading)
//
//            val tourDetails = fetchBookingOrderUseCase(bookingId)
//            tourDetails.data?.let {
//                _uiState.tryEmit(
//                    BoardingPassUiState.Content(it.toBooking())
//                )
//            }
//        }
//    }
}
//    init {
//        _uiState.tryEmit(BoardingPassUiState.Loading)
//        try {
//            val booking = fetchBookingOrderUseCase(objectId = String())
//            booking.data?.let {
//                _uiState.tryEmit(
//                    BoardingPassUiState.Content(it.toBooking())
//                )
//            }
//            _uiState.tryEmit(BoardingPassUiState.Content(booking))
//            Log.i("Profile", "name = ${booking.departure}")
//        } catch (e: Exception) {
//            val errorState = BoardingPassUiState.Error(e.stackTraceToString())
//            _uiState.tryEmit(errorState)
//        }
//    }
