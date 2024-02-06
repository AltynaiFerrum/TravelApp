package com.jyldyzferr.travelapp.domain.usecases.sign_up

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain

interface SignUpUseCase {
    suspend operator fun invoke(
        email: String,
        password: String,
        name: String,
        lastName: String,
    ): Result<UserDomain>
}