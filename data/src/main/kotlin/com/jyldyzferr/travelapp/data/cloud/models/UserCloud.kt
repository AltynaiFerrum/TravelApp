package com.jyldyzferr.travelapp.data.cloud.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCloud(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("updatedAt")
    val updatedAt: String
): Parcelable