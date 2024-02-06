package com.jyldyzferr.travelapp.data.cloud.models.tours

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToursNewResponse(
    @SerializedName("results")
    val results: List<ToursNewCloud>
): Parcelable