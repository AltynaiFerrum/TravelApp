package com.jyldyzferr.travelapp.domain.usecases.current_user

import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

interface SaveCurrentUserUseCase {
    operator fun invoke(user: UserDomain)
}


class SaveCurrentUserUseCaseImpl(
    private val repository: CurrentUserRepository
) : SaveCurrentUserUseCase{
    override fun invoke(user: UserDomain){
        return repository.saveCurrentUser(user)
    }
}

