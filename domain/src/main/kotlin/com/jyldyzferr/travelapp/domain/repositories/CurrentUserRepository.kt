package com.jyldyzferr.travelapp.domain.repositories

import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain

interface CurrentUserRepository {

    fun saveCurrentUser(user: UserDomain)

    fun fetchCurrentUser(): UserDomain

    fun clearCurrentUser()

    fun isOnboardingPassed(): Boolean

    fun setOnboardingShowed()

    fun clearOnboarding()
}