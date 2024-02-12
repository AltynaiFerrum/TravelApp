package com.jyldyzferr.travelapp.domain.models

data class ToursNewDomain(
    val createdAt: String,
    val description: String,
    val image: String,
    val location: String,
    val objectId: String,
    val price: String,
    val rating: Int,
    val title: String,
    val updatedAt: String
) {
    companion object{
        val unknown = ToursNewDomain(
            createdAt = "",
            objectId = "jhhk",
            updatedAt = "",
            description = "",
            image = "",
            title = "",
            price = "",
            location = "",
            rating = 3

        )
    }
}