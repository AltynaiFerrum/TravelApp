package com.jyldyzferr.travelapp.data.cloud.models.booking

import com.google.gson.annotations.SerializedName

data class BookingCloud(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("departure")
    val departure: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("location")
    val location: String,
//    @SerializedName("money")
//    val money: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("passport")
    val passport: String,
    @SerializedName("return")
    val returnDate: String,
    @SerializedName("updatedAt")
    val updatedAt: String
): java.io.Serializable