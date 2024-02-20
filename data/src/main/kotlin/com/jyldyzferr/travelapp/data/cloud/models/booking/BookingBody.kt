package com.jyldyzferr.travelapp.data.cloud.models.booking

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.data.cloud.models.CreateResponse
import com.jyldyzferr.travelapp.domain.models.BookingBodyDomain
import com.jyldyzferr.travelapp.domain.models.CreateResponseDomain


private const val OBJECT_ID = "objectId"
private const val CREATED_AT = "createdAt"

data class BookingBody(
    @SerializedName(OBJECT_ID)
    val id: String,
//    @SerializedName(CREATED_AT)
//    val createdAt: String,
) {
    companion object {
        val unknown = BookingBody(
            id = "",
//            createdAt = ""
        )
    }
}


fun BookingBody.toDomain(): BookingBodyDomain = BookingBodyDomain(
    id = id,
)