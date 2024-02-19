package com.jyldyzferr.travelapp.domain.models

data class BookingDomain(
    val departure: String,
    val destination: String,
    val location: String,
//    val money: String,
    val objectId: String,
    val passport: String,
    val returnDate: String,
    val updatedAt: String
) {
    companion object {
        val unknown = BookingDomain(
            departure = "It Academy",
            destination = "Job",
            location = "",
//            money = "",
            objectId = "",
            passport = "",
            returnDate = "",
            updatedAt = ""
        )
    }
}