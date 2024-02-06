package com.jyldyzferr.travelapp.domain.usecases.current_user

import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

interface FetchCurrentUserUseCase {
    operator fun invoke(): UserDomain
}

class FetchCurrentUserUseCaseImpl(
    private val repository: CurrentUserRepository
) : FetchCurrentUserUseCase {

    override fun invoke(): UserDomain {
        return repository.fetchCurrentUser()
    }
}