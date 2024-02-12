package com.jyldyzferr.travelapp.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsUseCase
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.models.toTour
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainToursViewModel @Inject constructor(
    private val fetchOshToursUseCase: FetchAllTripsUseCase,
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(MainUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch {
            _uiStateFlow.tryEmit(MainUiState.Loading)
            val contentState = MainUiState.Content(
                tour = fetchAllTrips()
            )
                .copy( tour = fetchAllTrips())
            _uiStateFlow.tryEmit(contentState)
        }
    }

    private suspend fun fetchAllTrips(): List<Tour> {
        val trips = fetchOshToursUseCase().map { it.toTour() }
        delay(2_000)
        return trips
    }
}






