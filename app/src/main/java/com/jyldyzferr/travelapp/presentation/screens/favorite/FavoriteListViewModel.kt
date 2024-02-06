package com.jyldyzferr.travelapp.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.travelapp.domain.usecases.saved.FetchAllSavedToursUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteListViewModel @Inject constructor(
    private val fetchAllSavedToursUseCase: FetchAllSavedToursUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow<WishlistUiState>(WishlistUiState.Loading)
    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    init {
        fetchAllSavedToursUseCase()
            .onEach { tours ->
                _uiState.tryEmit(
                    WishlistUiState.Loaded(
                        tours = tours
                    )
                )
            }.launchIn(viewModelScope)
    }
}

