package com.jyldyzferr.travelapp.presentation.screens.profile.premium


class CountriesApiImpl : CountriesApi {
    override suspend fun getCountriesList(): List<Country> {
        return getRestCountriesList()
    }
}