package com.jyldyzferr.travelapp.data.repositories

import android.util.Log
import com.jyldyzferr.travelapp.data.cloud.service.LoginService
import com.jyldyzferr.travelapp.data.cloud.models.SignUpParams
import com.jyldyzferr.travelapp.data.mappers.toDomain
import com.jyldyzferr.travelapp.domain.models.CreateResponseDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.LoginRepository
import java.time.LocalDateTime
import java.util.concurrent.CancellationException
import javax.inject.Inject
import com.jyldyzferr.travelapp.domain.common.Result

const val DEFAULT_ERROR_MESSAGE = "Something went wrong!"

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginService
) : LoginRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): Result<UserDomain> {
        return try {
            val response = service.signIn("{\"email\":\"$email\", \"password\":\"$password\"}")
            val result = response.body()?.results!!.first()
            Result.Success(data = result.toDomain())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String,
        lastName: String
    ): Result<CreateResponseDomain> = try {
        val params = SignUpParams(
            name = name,
            email = email,
            password = password,
            lastName = lastName
        )
        val response = service.signUp(params)
        val result = response.body()!!
        Result.Success(
            CreateResponseDomain(
                id = result.id,
            )
        )
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.e("Travel App", e.stackTraceToString())
        Result.Error(DEFAULT_ERROR_MESSAGE)
    }
}

