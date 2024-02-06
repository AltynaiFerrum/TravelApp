package com.jyldyzferr.travelapp.presentation.screens.profile.premium


sealed interface ListScreenState {
    object Loading : ListScreenState
    data class Error(val message: String) : ListScreenState
    data class Success(
        val countriesList: List<Country>,
        val selectedCountry: Country,
        val selectedItemIndex: Int = 0,
    ) : ListScreenState
}
