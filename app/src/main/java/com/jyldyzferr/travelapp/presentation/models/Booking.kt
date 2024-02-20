package com.jyldyzferr.travelapp.presentation.models

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain
import javax.annotation.concurrent.Immutable

data class Booking(
    val departure: String,
    val destination: String,
    val location: String,
//    val money: String,
    val objectId: String?,
    val passport: String,
    val returnDate: String,
    val updatedAt: String?
) {
    fun isUnknown() = this == unknown
    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Booking(
            location = String(),
            objectId = null,
            updatedAt = null,
            passport = String(),
            destination = String(),
            departure = String(),
//            money = String(),
            returnDate = String()
        )
    }
}
fun BookingDomain.toUser() = this.run {
    if (this == BookingDomain.unknown) return@run User.unknown
    Booking(
        objectId = objectId,
        updatedAt = updatedAt,
        location = location,
        passport = passport,
        destination = destination,
        departure = departure,
        returnDate = returnDate
    )
}

