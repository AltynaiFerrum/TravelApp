package com.jyldyzferr.travelapp.data.cloud.models

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.CreateResponseDomain

data class CreateResponse (
    @SerializedName("objectId")
    val id: String,
)

fun CreateResponse.toDomain(): CreateResponseDomain = CreateResponseDomain(
    id = id,
)