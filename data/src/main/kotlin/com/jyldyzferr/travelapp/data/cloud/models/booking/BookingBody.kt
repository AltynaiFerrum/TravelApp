package com.jyldyzferr.travelapp.data.cloud.models.booking

import com.google.gson.annotations.SerializedName


private const val OBJECT_ID = "objectId"
private const val CREATED_AT = "createdAt"

data class BookingBody(
    @SerializedName(OBJECT_ID)
    val objectId: String,
    @SerializedName(CREATED_AT)
    val createdAt: String,
) {
    companion object {
        val unknown = BookingBody(
            objectId = "",
            createdAt = ""
        )
    }
}