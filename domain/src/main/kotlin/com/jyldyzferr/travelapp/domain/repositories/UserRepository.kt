package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.common.Result

interface UserRepository {
    suspend fun fetchUserById(id: String): Result<UserDomain>

    suspend fun fetchAllUsers(): Result<List<UserDomain>>

    suspend fun deleteUserById(id: String)

    suspend fun updateUser(updateUser: UserDomain): Result<UserDomain>



//    fun isSave(id: String): Flow<Boolean>
}