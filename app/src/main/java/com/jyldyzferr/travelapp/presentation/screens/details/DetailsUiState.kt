package com.jyldyzferr.travelapp.presentation.screens.details

import com.jyldyzferr.travelapp.presentation.models.Tour


//sealed class ContentType(
//    val createdAt: String,
//    val description: String,
//    val image: String,
//    val objectId: String,
//    val title: String,
//    val updatedAt: String
//) {
//    data class ToursContent(val tour: Tour) : ContentType(
//        createdAt = tour.createdAt,
//        description = tour.description,
//        image = tour.image,
//        objectId = tour.objectId,
//        title = tour.title,
//        updatedAt = tour.updatedAt
//    )
//
//    data object Unknown : ContentType(
//        createdAt = String(),
//        description = String(),
//        image = String(),
//        objectId = String(),
//        title = String(),
//        updatedAt = String()
//    )
//}


sealed class DetailsUiState {

    data object Initial : DetailsUiState()

    data object Loading : DetailsUiState()

    data class Error(val message: String) : DetailsUiState()

    data class Content(
        val tour: Tour,
        val isSaved: Boolean = false
    ) : DetailsUiState()
}
