package com.jyldyzferr.travelapp.di

import com.jyldyzferr.travelapp.data.repositories.BookingRepositoryImpl
import com.jyldyzferr.travelapp.data.repositories.CurrentUserRepositoryImpl
import com.jyldyzferr.travelapp.data.repositories.LoginRepositoryImpl
import com.jyldyzferr.travelapp.data.repositories.TourRepositoryImpl
import com.jyldyzferr.travelapp.data.repositories.UserRepositoryImpl
import com.jyldyzferr.travelapp.domain.repositories.BookingRepository
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository
import com.jyldyzferr.travelapp.domain.repositories.LoginRepository
import com.jyldyzferr.travelapp.domain.repositories.TourRepository
import com.jyldyzferr.travelapp.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindLoginRepository(
        implementation: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    fun bindCurrentUserRepository(
        implementation: CurrentUserRepositoryImpl
    ): CurrentUserRepository

    @Binds
    fun bindUserRepository(
        implementation: UserRepositoryImpl
    ): UserRepository

    @Binds
    fun bindOshRepository(
        implementation: TourRepositoryImpl
    ): TourRepository
    @Binds
    fun bindBookingRepository(
        implementation: BookingRepositoryImpl
    ): BookingRepository
}