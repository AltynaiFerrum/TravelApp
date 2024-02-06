package com.jyldyzferr.travelapp.di

import com.jyldyzferr.travelapp.domain.managers.OnboardingManager
import com.jyldyzferr.travelapp.domain.managers.OnboardingManagerImpl
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManagerImpl
import com.jyldyzferr.travelapp.presentation.managers.toast.ShowToastUseCase
import com.jyldyzferr.travelapp.presentation.managers.toast.ToastManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ManagersModule {

    @Binds
    fun bindOnboardingManager(
        impl: OnboardingManagerImpl
    ): OnboardingManager

    @Binds
    fun bindShowToastUseCase(
        impl: ToastManager
    ): ShowToastUseCase

    @Binds
    @Singleton
    fun bindNavigatorManager(
        impl: NavigatorManagerImpl
    ): NavigatorManager
}