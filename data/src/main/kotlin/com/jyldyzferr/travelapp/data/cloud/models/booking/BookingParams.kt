package com.jyldyzferr.travelapp.data.cloud.models.booking

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain

data class BookingParams(
//    @SerializedName("createdAt")
//    val createdAt: String,
    @SerializedName("departure")
    val departure: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("location")
    val location: String,
//    @SerializedName("money")
//    val money: String,
    @SerializedName("passport")
    val passport: String,
    @SerializedName("return")
    val returnDate: String,
) : java.io.Serializable


fun BookingBasketDomain.toDomain() = this.run {
    BookingParams(
        destination = destination,
        location = location,
        returnDate = returnDate,
        passport = passport,
        departure = departure
    )
}
