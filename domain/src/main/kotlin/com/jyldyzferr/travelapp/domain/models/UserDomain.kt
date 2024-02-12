package com.jyldyzferr.travelapp.domain.models


data class UserDomain(
    val avatar: String?,
    val createdAt: String,
    val email: String,
    val lastName: String,
    val location: String?,
    val name: String,
    val objectId: String,
    val password: String,
    val updatedAt: String
) {

    companion object {
        val unknown = UserDomain(
            avatar = null,
            createdAt = String(),
            email = "gmail.com",
            location = null,
            name = "Unknown",
            objectId = String(),
            password = String(),
            updatedAt = String(),
            lastName = String()
        )
    }
}