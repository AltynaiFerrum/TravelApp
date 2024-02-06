package com.jyldyzferr.travelapp.domain.usecases.current_user

import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

interface ShouldOnboardingPassedUseCase {
    operator fun invoke(): Boolean
}

class ShouldOnboardingPassedUseCaseImpl(
    private val repository: CurrentUserRepository
) : ShouldOnboardingPassedUseCase{

    override fun invoke(): Boolean {
        return repository.isOnboardingPassed()
    }
}