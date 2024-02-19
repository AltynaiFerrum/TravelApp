package com.jyldyzferr.travelapp.data.mappers

import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache
import com.jyldyzferr.travelapp.data.cloud.models.UserCloud
import com.jyldyzferr.travelapp.data.cloud.models.booking.BookingCloud
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain

fun UserCloud.toDomain(): UserDomain = this.run {
    UserDomain(
        avatar = avatar,
        createdAt = createdAt,
        email = email,
        location = location,
        lastName = lastName ?: "",
        name = name,
        objectId = objectId,
        password = password,
        updatedAt = updatedAt,
    )
}
fun BookingCloud.toDomain(): BookingDomain = this.run {
    BookingDomain(
        createdAt = createdAt,
        location = location,
        objectId = objectId,
        updatedAt = updatedAt,
        passport = passport,
        departure = departure,
        destination = destination,
//        money = money,
        returnDate = returnDate
    )
}


fun ToursNewDomain.toCache(): TourDetailsCache = this.run {
    TourDetailsCache(
        createdAt = createdAt,
        id = objectId,
        updatedAt = updatedAt,
        description = description,
        image = image,
        title = title,
        price = price,
        location = location,
        rating = rating
    )
}

fun TourDetailsCache.toDomain(): ToursNewDomain = this.run {
    ToursNewDomain(
        createdAt = createdAt,
        objectId = id,
        updatedAt = updatedAt,
        description = description,
        image = image,
        title = title,
        price = price,
        location = location,
        rating = rating
    )
}


