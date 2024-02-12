package com.jyldyzferr.travelapp.presentation.models

import com.jyldyzferr.travelapp.domain.models.ToursNewDomain

data class Tour(
    val createdAt: String,
    val description: String,
    val image: String,
    val objectId: String,
    val title: String,
    val updatedAt: String,
    val location: String,
    val price: String,
    val rating: Int,
) {
    fun isUnknown() = this == unknown
    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Tour(
            createdAt = String(),
            objectId = String(),
            updatedAt = String(),
            description = String(),
            image = String(),
            title = String(),
            location = String(),
            price = String(),
            rating = 2
        )
    }
}

fun ToursNewDomain.toTour() = this.run {
    if (this == ToursNewDomain.unknown) return@run Tour.unknown
    Tour(
        createdAt = createdAt,
        description = description,
        image = image,
        objectId = objectId,
        title = title,
        updatedAt = updatedAt,
        price = price,
        location = location,
        rating = rating

    )
}

fun Tour.toDomain() = this.run {
    ToursNewDomain(
        createdAt = createdAt,
        description = description,
        image = image,
        objectId = objectId,
        title = title,
        updatedAt = updatedAt,
        price = price,
        location = location,
        rating = rating
    )
}




