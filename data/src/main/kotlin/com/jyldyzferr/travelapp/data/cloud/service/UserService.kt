package com.jyldyzferr.travelapp.data.cloud.service

import com.jyldyzferr.travelapp.data.cloud.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("Users")
    suspend fun fetchUserById(
        @Query("where") params: String,
    ): UserResponse

    @GET("Users")
    suspend fun fetchAllUsers(): UserResponse
}