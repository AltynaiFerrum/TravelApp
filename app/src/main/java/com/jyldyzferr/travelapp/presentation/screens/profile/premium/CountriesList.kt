package com.jyldyzferr.travelapp.presentation.screens.profile.premium

import androidx.annotation.DrawableRes

data class Country(
    val name: String,
    val touristPlaces: List<TouristPlace>
)

data class TouristPlace
 constructor(
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val images: Int
)
