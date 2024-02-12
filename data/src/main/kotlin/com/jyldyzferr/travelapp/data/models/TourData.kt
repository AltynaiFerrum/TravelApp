package com.jyldyzferr.travelapp.data.models

data class TourData(
    val createdAt: String,
    val description: String,
    val image: String,
    val objectId: String,
    val title: String,
    val updatedAt: String
) {
    companion object{
        val unknown = TourData(
            createdAt = String(),
            description = String(),
            image =String(),
            objectId = String(),
            title = String(),
            updatedAt = String()
        )
    }
}

