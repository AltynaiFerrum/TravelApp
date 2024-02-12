package com.jyldyzferr.travelapp.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.usecases.saved.IsTourSavedUseCase
import com.jyldyzferr.travelapp.domain.usecases.saved.TourOperatorUseCase
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsByIdUseCase
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsUseCase
import com.jyldyzferr.travelapp.presentation.models.toDomain
import com.jyldyzferr.travelapp.presentation.models.toTour
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val fetchTourByIdUseCase: FetchAllTripsByIdUseCase,
    private val fetchOshToursUseCase: FetchAllTripsUseCase,
    private val tourOperatorUseCase: TourOperatorUseCase,
    private val isTourSavedUseCase: IsTourSavedUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiState.tryEmit(DetailsUiState.Error(throwable.localizedMessage ?: ""))
    }

    fun init(tourId: String) {
        viewModelScope.launch(handler + Dispatchers.IO) {
            fetchTripById(tourId)
        }
    }

    private fun fetchTripById(tourId: String) {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiState.tryEmit(DetailsUiState.Loading)

            val tourDetails = fetchTourByIdUseCase(tourId)
            tourDetails.data?.let {
                _uiState.tryEmit(
                    DetailsUiState.Content(it.toTour())
                )
                checkIsTourSaved(tourId)
            }
        }
    }


    fun addOrDeleteTour(tourId: String) {
        val uiState = _uiState.value as? DetailsUiState.Content ?: return
        viewModelScope.launch(Dispatchers.IO) {
            if (uiState.isSaved) {
                tourOperatorUseCase.removeTour(tourId)
                checkIsTourSaved(tourId)
            } else {
                tourOperatorUseCase.saveTour(uiState.tour.toDomain())
                checkIsTourSaved(tourId)
            }
        }
    }

    fun checkIsTourSaved(tourId: String) {
        isTourSavedUseCase.invoke(tourId)
            .onEach { isSaved: Boolean ->
                val uiState = _uiState.value as? DetailsUiState.Content ?: return@onEach
                _uiState.tryEmit(uiState.copy(isSaved = isSaved))
            }
            .launchIn(viewModelScope)
    }
}






