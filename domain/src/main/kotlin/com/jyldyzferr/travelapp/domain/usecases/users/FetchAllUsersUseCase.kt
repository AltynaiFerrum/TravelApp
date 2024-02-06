package com.jyldyzferr.travelapp.domain.usecases.users

import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository

//interface FetchAllUsersUseCase {
//    suspend operator fun invoke(): List<UserDomain>
//}
//
//class FetchAllUsersUseCaseImpl(
//    private val userRepository: UserRepository,
//    private val currentUserRepository: CurrentUserRepository
//) : FetchAllUsersUseCase {
//    override suspend fun invoke(): List<UserDomain> {
//        val allUsers = userRepository.fetchAllUsers().data
//        val currentUser = currentUserRepository.fetchCurrentUser()
//        return allUsers?.filter { it.objectId != currentUser.objectId } ?: listOf()
//    }
//}

interface FetchAllUsersUseCase {
    suspend operator fun invoke(): UserDomain
}

class FetchAllUsersUseCaseImpl(
    private val currentUserRepository: CurrentUserRepository
) : FetchAllUsersUseCase {
    override suspend fun invoke(): UserDomain {
        val currentUser = currentUserRepository.fetchCurrentUser()
        return currentUser
    }
}