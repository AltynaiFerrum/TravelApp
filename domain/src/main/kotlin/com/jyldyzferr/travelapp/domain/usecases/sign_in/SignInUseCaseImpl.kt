package com.jyldyzferr.travelapp.domain.usecases.sign_in

import java.util.regex.Pattern
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.LoginRepository


class SignInUseCaseImpl constructor(
    private val repository: LoginRepository,
) : SignInUseCase {

//    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
//        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
//    )
//
//    private fun isValidString(str: String): Boolean {
//        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
//    }

    override suspend fun invoke(
        email: String,
        password: String
    ): Result<UserDomain> {
        if (password.isEmpty()) {
            return Result.Error(message = "First fill in password!")
        }
        if (password.length < 8) {
            return Result.Error(message = "Incorrect fill password")
        }

        return repository.signIn(
            email = email,
            password = password
        )
    }
}

internal fun String.isValidString(): Boolean {
    val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a" +
                "-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    )
    return emailPattern.matcher(this).matches()
}