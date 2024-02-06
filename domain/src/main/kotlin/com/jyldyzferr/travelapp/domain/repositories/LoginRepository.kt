package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.CreateResponseDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain

interface LoginRepository {
    suspend fun signIn(email: String, password: String): Result<UserDomain>

    suspend fun signUp(
        name: String,
        email: String,
        password: String,
        lastName: String,
    ): Result<CreateResponseDomain>
}