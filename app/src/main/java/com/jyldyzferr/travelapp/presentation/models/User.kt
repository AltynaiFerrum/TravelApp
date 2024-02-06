package com.jyldyzferr.travelapp.presentation.models

import com.jyldyzferr.travelapp.domain.models.UserDomain


data class User(
    val avatar: String,
    val createdAt: String,
    val email: String,
    val lastName: String,
    val location: String,
    val name: String,
    val objectId: String,
    val password: String,
    val updatedAt: String
){
    fun isUnknown() = this == unknown
    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = User(
            avatar = String(),
            createdAt = String(),
            email = "gmail.com",
            lastName = "Last Name",
            name = "Name",
            location = String(),
            objectId = String(),
            password = String(),
            updatedAt = String()
        )
    }
}

fun UserDomain.toUser() = this.run {
    if (this == UserDomain.unknown) return@run User.unknown
    User(
        avatar = avatar,
        createdAt = createdAt,
        email = email,
        lastName = lastName,
        name = name,
        objectId = objectId,
        password = password,
        updatedAt = updatedAt,
        location = location
    )
}