package com.jyldyzferr.travelapp.presentation.models

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain
import javax.annotation.concurrent.Immutable

@Immutable
data class Booking(
    val departure: String,
    val destination: String,
    val location: String,
//    val money: String,
    val objectId: String,
    val passport: String,
    val returnDate: String,
    val updatedAt: String
) {
    fun isUnknown() = this == unknown
    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Booking(
            location = String(),
            objectId = String(),
            updatedAt = String(),
            passport = String(),
            destination = String(),
            departure = String(),
//            money = String(),
            returnDate = String()
        )
    }
}

