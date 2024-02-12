package com.jyldyzferr.travelapp.presentation.screens.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.usecases.search.SearchByQueryTripsUseCase
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsUseCase
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.models.toTour
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchUiState(
    val query: String = "",
    val tours: List<Tour> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val fetchAllTripsUseCase: FetchAllTripsUseCase,
    private val searchByQueryTripsUseCase: SearchByQueryTripsUseCase
) : ViewModel() {

    private val searQueryFlow = MutableStateFlow("")


    private val _uiStateFlow = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiStateFlow.asStateFlow()

    init {
        searQueryFlow.onEach { query ->
            _uiStateFlow.tryEmit(
                _uiStateFlow.value.copy(
                    query = query,
                    isLoading = true
                )
            )
        }
            .debounce(300)
            .onEach(::startSearch)
            .launchIn(viewModelScope)
    }

    private fun startSearch(query: String) {
        viewModelScope.launch {
            val content = fetchAllTripsUseCase.invoke()
            val result = content.filter { it.title.contains(query, ignoreCase = true) }
            val tours = result.map { it.toTour() }
            _uiStateFlow.tryEmit(
                _uiStateFlow.value.copy(
                    tours = tours,
                    isLoading = false
                )
            )
//            val trips = searchByQueryTripsUseCase.searchByQuery(query)
//            val result = trips.filter { it.title.contains(query, ignoreCase = true) }
////            _uiStateFlow.tryEmit(_uiStateFlow.value.copy(tours = trips.data!!.map { it.toTour() }, isLoading = false))
////            val content = fetchAllTripsUseCase.invoke()
//            val tours = result.map { it.toTour() }
//            _uiStateFlow.tryEmit(
//                _uiStateFlow.value.copy(
//                    tours = tours,
//                    isLoading = false
//                )
//            )
        }
    }

    fun onValueChange(value: String) {
        searQueryFlow.tryEmit(value)
    }

        private fun filterTourListByQuery(
        tripList: List<ToursNewDomain>,
        query: String
    ): List<ToursNewDomain> {
        return tripList.filter { it.title.contains(query, ignoreCase = true) }
    }
}