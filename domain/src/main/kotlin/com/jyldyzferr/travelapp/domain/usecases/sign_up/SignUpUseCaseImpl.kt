package com.jyldyzferr.travelapp.domain.usecases.sign_up

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.LoginRepository
import com.jyldyzferr.travelapp.domain.repositories.UserRepository


class SignUpUseCaseImpl constructor(
    private val repository: LoginRepository,
    private val userRepository: UserRepository,

    ) : SignUpUseCase {
    override suspend fun invoke(
        email: String,
        password: String,
        name: String,
        lastName: String,
    ): Result<UserDomain> {
        if (name.isEmpty()) {
            return Result.Error(message = "First fill in name!")
        }
        if (lastName.isEmpty()) {
            return Result.Error(message = "First fill in last name!")
        }

//        if (email.isEmpty()) {
//            return Result.Error(message = "First fill in email!")
//        }
        if (password.isEmpty()) {
            return Result.Error(message = "First fill in password!")
        }

        if (password.length < 8) {
            return Result.Error(message = "Incorrect fill password")
        }

        val response = repository.signUp(
            name = name,
            email = email,
            password = password,
            lastName = lastName
        )
        return userRepository.fetchUserById(response.data?.id ?: String())
    }
}