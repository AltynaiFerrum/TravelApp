package com.jyldyzferr.travelapp.data.cloud.models.booking

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookingResponse(
    @SerializedName("results")
    val results: List<BookingCloud>
): Parcelable