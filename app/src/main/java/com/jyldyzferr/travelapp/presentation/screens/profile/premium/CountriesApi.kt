package com.jyldyzferr.travelapp.presentation.screens.profile.premium


interface CountriesApi {
    suspend fun getCountriesList(): List<Country>
}