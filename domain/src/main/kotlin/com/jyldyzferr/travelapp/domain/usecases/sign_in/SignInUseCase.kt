package com.jyldyzferr.travelapp.domain.usecases.sign_in

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.UserDomain


interface SignInUseCase {
    suspend operator fun invoke (
        email: String,
        password: String
    ) : Result<UserDomain>
}