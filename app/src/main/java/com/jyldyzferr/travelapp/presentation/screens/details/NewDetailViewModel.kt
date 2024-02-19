package com.jyldyzferr.travelapp.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



private const val TAG = "DetailViewModel"
@HiltViewModel
class DetailViewModel @Inject constructor(
//    private val getSingleListingUseCase: GetSingleListingUseCase
): ViewModel() {

    private val _singleListingState = MutableStateFlow(SingleListingState(StateWrapper.Empty))
    val singleListingState get() = _singleListingState.asStateFlow()

    private var _property = MutableStateFlow<Property?>(null)
    val property get() = _property.asStateFlow()


    fun setProperty(property: Property){
        _property.value = property
    }

//    fun getListing(id: String) {
//
//        viewModelScope.launch {
//            getSingleListingUseCase(id).collectLatest { state->
//                _singleListingState.update {
//                    singleListingState.value.copy(
//                        state = state
//                    )
//                }
//            }
//        }
//    }
}

data class SingleListingState(
    var state: StateWrapper<Property>
)

sealed class StateWrapper<out T> {
    data class Success<out T>(val data: T) : StateWrapper<T>()
    data class Failure<T>(
        val errorMessage: String
    ) : StateWrapper<T>()

    object Loading : StateWrapper<Nothing>()

    object Empty : StateWrapper<Nothing>()
////    object Complete : StateWrapper<Nothing>()
}
