package com.jyldyzferr.travelapp.data.cloud.models.booking

import com.google.gson.annotations.SerializedName

data class BookingResponse(
    @SerializedName("results")
    val results: List<BookingCloud>
): java.io.Serializable
