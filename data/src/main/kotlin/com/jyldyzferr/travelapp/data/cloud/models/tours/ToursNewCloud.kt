package com.jyldyzferr.travelapp.data.cloud.models.tours

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ToursNewCloud(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rating")
    val rating: Int,
    ) :Parcelable


fun ToursNewCloud.toDomain() = this.run {
    ToursNewDomain(
        createdAt = createdAt,
        description = description,
        image = image.url,
        objectId = objectId,
        title = title,
        updatedAt = updatedAt,
        location = location,
        price = price,
        rating = rating
    )
}