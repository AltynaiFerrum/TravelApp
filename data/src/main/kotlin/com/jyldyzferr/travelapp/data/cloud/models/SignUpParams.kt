package com.jyldyzferr.travelapp.data.cloud.models

import com.google.gson.annotations.SerializedName

data class SignUpParams(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("last_name")
    val lastName: String,
)