package com.jyldyzferr.travelapp.data.repositories

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.service.UserService
import com.jyldyzferr.travelapp.data.mappers.toDomain
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.UserRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService,
//    private val dao: TourDao,
) : UserRepository {
    override suspend fun fetchUserById(id: String): Result<UserDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchUserById(params)
            val user = response.results.first().toDomain()
            Result.Success(data = user)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllUsers(): Result<List<UserDomain>> {
        return try {
            val userCloud = service.fetchAllUsers().results
            Result.Success(data = userCloud.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteUserById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(updateUser: UserDomain): Result<UserDomain> {
        TODO("Not yet implemented")
    }

}