package com.jyldyzferr.travelapp.data.cloud.service

import com.jyldyzferr.travelapp.data.cloud.models.CreateResponse
import com.jyldyzferr.travelapp.data.cloud.models.SignUpParams
import com.jyldyzferr.travelapp.data.cloud.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @GET("Users")
    suspend fun signIn(
        @Query("where")params: String
    ): Response<UserResponse>

    @POST("Users")
    suspend fun signUp(
        @Body params: SignUpParams
    ): Response<CreateResponse>

}