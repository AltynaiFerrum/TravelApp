package com.jyldyzferr.travelapp.domain.usecases.current_user

import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

interface SetOnboardingShowedUseCase {
    operator fun invoke()
}

class SetOnboardingShowedUseCaseImpl(
    private val repository: CurrentUserRepository
) : SetOnboardingShowedUseCase{

    override fun invoke() {
        return repository.setOnboardingShowed()
    }
}