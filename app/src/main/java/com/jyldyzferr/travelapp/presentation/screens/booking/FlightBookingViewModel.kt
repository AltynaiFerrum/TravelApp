package com.jyldyzferr.travelapp.presentation.screens.booking

import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.usecases.booking.BookingFlightUseCase
import com.jyldyzferr.travelapp.domain.usecases.booking.CurrentBookingUseCase
import com.jyldyzferr.travelapp.domain.usecases.booking.FetchBookingOrderUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.jyldyzferr.travelapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.managers.toast.ShowToastUseCase
import com.jyldyzferr.travelapp.presentation.mapper.toBooking
import com.jyldyzferr.travelapp.presentation.mapper.toBookingUi
import com.jyldyzferr.travelapp.presentation.models.Booking
import com.jyldyzferr.travelapp.presentation.navigations.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.SignInDestination
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.default_error_message
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpEvent
import com.jyldyzferr.travelapp.presentation.screens.booking_pass.SELECT_FLIGHT_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val SUCCESS_ADDED_TO_BASKET = "Successfully Added to Basket"
const val INTERNET_ERROR_MESSAGE = "No internet connection"

@HiltViewModel
class FlightBookingViewModel @Inject constructor(
    private val bookingFlightUseCase: BookingFlightUseCase,
    private val showToastUseCase: ShowToastUseCase,
    private val fetchAllFromBasketUseCase: FetchBookingOrderUseCase,
    private val currentBookingUseCase: CurrentBookingUseCase,
    private val connectivityManager: ConnectivityManager,
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(BookingUiState())
    val uiStateFlow: StateFlow<BookingUiState> = _uiStateFlow.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()

//    init {
//        fetchFromBasket()
//    }

    fun onEvent(event: BookingEvent) {
        when (event) {
            is BookingEvent.OnLocationChanged -> doLocationChanged(event)
            is BookingEvent.OnDestinationChanged -> doDestinationChanged(event)
            is BookingEvent.OnDepartureChanged -> doDepartureChanged(event)
            is BookingEvent.OnReturnDateChanged -> doReturnDateChanged(event)
            is BookingEvent.OnPassportChanged -> doPassportChanged(event)
            is BookingEvent.OnFlightSearchClick -> doFlightSearchClick()
        }
    }

    private fun doLocationChanged(event: BookingEvent.OnLocationChanged) {
        _uiStateFlow.update { currentState ->
            currentState.copy(location = event.value)
        }
    }

    private fun doDestinationChanged(event: BookingEvent.OnDestinationChanged) {
        _uiStateFlow.update { currentState ->
            currentState.copy(destination = event.value)
        }
    }

    private fun doDepartureChanged(event: BookingEvent.OnDepartureChanged) {
        _uiStateFlow.update { currentState ->
            currentState.copy(departure = event.value)
        }
    }

    private fun doReturnDateChanged(event: BookingEvent.OnReturnDateChanged) {
        _uiStateFlow.update { currentState ->
            currentState.copy(returnDate = event.value)
        }
    }

    private fun doPassportChanged(event: BookingEvent.OnPassportChanged) {
        _uiStateFlow.update { currentState ->
            currentState.copy(passport = event.value)
        }
    }

    private fun doFlightSearchClick() {
        viewModelScope.launch {
            val result = bookingFlightUseCase(
                location = uiStateFlow.value.location,
                destination = uiStateFlow.value.destination,
                departure = uiStateFlow.value.departure,
                returnDate = uiStateFlow.value.returnDate,
                passport = uiStateFlow.value.passport
            )
            when (result) {
                is Result.Error -> {
                    showToastUseCase.showToast(result.message ?: default_error_message)
                    Log.e("TravelApp", "message = ${result.message}")
                }

                is Result.Success -> {
                    val user = result.data ?: return@launch
//                    currentBookingUseCase(user)
                    _navCommandFlow.tryEmit(SELECT_FLIGHT_ROUTE)
//                    navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE, true)
                    Log.e("c", "data = ${result.data}")
                }
            }
        }
    }
//    private fun doFlightSearchClick() {
//        viewModelScope.launch {
//            val result = bookingFlightUseCase(
//               locatio
//            )
//            when(result){
//                is Result.Error -> {
//                    showToastUseCase.showToast(result.message ?: default_error_message)
//                    Log.e("TravelApp", "message = ${result.message}")
//                }
//                is Result.Success -> {
//                    val user = result.data ?: return@launch
//                    saveCurrentUserUseCase(user)
////                    _navControllerFlow.tryEmit(BottomBarNavigationDestinations.MAIN.route)
//                    navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE, true)
//                    Log.e("TravelApp", "data = ${result.data}")
//                }
//            }
//        }
//    }

//    fun addToBasket(menuUi: Booking) {
//        if (!isNetworkAvailable()) {
//            _uiStateFlow.tryEmit(
//                BookingUiState(
//                    error = INTERNET_ERROR_MESSAGE
//                )
//            )
//            return
//        }
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                bookingFlightUseCase.bookingFlight(menuUi.toBookingUi())
//                withContext(Dispatchers.Main) {
//                    showToastUseCase.showToast(SUCCESS_ADDED_TO_BASKET)
//                }
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    showToastUseCase.showToast(default_error_message)
//                }
//            }
//        }
//    }


//    fun fetchFromBasket() {
//        viewModelScope.launch(Dispatchers.IO) {
//
//            when (val result = fetchAllFromBasketUseCase.boardingPass()) {
//                is Result.Success -> {
//                    val data = result.data?.map { it.toBooking() } ?: emptyList()
//                    val updatedUiState = BookingUiState(fetchFromBasket = data)
//                    _uiStateFlow.emit(updatedUiState)
//                }
//
//                is Result.Error -> {
//                    val errorMessage = result.message
//                    val updatedUiState =
//                        BookingUiState().copy(error = errorMessage ?: default_error_message)
//                    _uiStateFlow.emit(updatedUiState)
//                }
//            }
//        }
//    }

    private fun isNetworkAvailable(): Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}