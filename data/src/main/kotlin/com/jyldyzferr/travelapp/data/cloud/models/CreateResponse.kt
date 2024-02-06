package com.jyldyzferr.travelapp.data.cloud.models

import com.google.gson.annotations.SerializedName
import com.jyldyzferr.travelapp.domain.models.CreateResponseDomain
import java.time.LocalDateTime

data class CreateResponse (
    @SerializedName("objectId")
    val id: String,
    @SerializedName("createAt")
    val createAt: String
)

fun CreateResponse.toDomain(): CreateResponseDomain = CreateResponseDomain(
    id = id,
    createAt = LocalDateTime.parse(createAt)
)