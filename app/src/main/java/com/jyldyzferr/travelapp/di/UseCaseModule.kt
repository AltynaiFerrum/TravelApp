package com.jyldyzferr.travelapp.di

import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository
import com.jyldyzferr.travelapp.domain.repositories.LoginRepository
import com.jyldyzferr.travelapp.domain.repositories.OshRepository
import com.jyldyzferr.travelapp.domain.repositories.UserRepository
import com.jyldyzferr.travelapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.FetchCurrentUserUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.SaveCurrentUserUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.current_user.SetOnboardingShowedUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.SetOnboardingShowedUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.current_user.ShouldOnboardingPassedUseCase
import com.jyldyzferr.travelapp.domain.usecases.current_user.ShouldOnboardingPassedUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.saved.FetchAllSavedToursUseCase
import com.jyldyzferr.travelapp.domain.usecases.saved.FetchAllSavedToursUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.saved.IsTourSavedUseCase
import com.jyldyzferr.travelapp.domain.usecases.saved.IsTourSavedUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.saved.TourOperatorUseCase
import com.jyldyzferr.travelapp.domain.usecases.saved.TourOperatorUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.search.SearchByQueryTripsUseCase
import com.jyldyzferr.travelapp.domain.usecases.search.SearchByQueryTripsUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.sign_in.SignInUseCase
import com.jyldyzferr.travelapp.domain.usecases.sign_in.SignInUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.sign_up.SignUpUseCase
import com.jyldyzferr.travelapp.domain.usecases.sign_up.SignUpUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsByIdUseCase
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsByIdUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsUseCase
import com.jyldyzferr.travelapp.domain.usecases.tours.FetchAllTripsUseCaseImpl
import com.jyldyzferr.travelapp.domain.usecases.users.FetchAllUsersUseCase
import com.jyldyzferr.travelapp.domain.usecases.users.FetchAllUsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideSignInUseCase(
        repository: LoginRepository
    ): SignInUseCase = SignInUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSignUpUseCase(
        repository: LoginRepository,
        userRepository: UserRepository,
    ): SignUpUseCase = SignUpUseCaseImpl(
        repository = repository,
        userRepository = userRepository
    )

    @Provides
    fun provideFetchCurrentUserUseCase(
        repository: CurrentUserRepository
    ): FetchCurrentUserUseCase = FetchCurrentUserUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideIsOnboardingPassedUseCase(
        repository: CurrentUserRepository
    ): ShouldOnboardingPassedUseCase = ShouldOnboardingPassedUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSaveCurrentUserUseCase(
        repository: CurrentUserRepository
    ): SaveCurrentUserUseCase = SaveCurrentUserUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSetOnboardingShowedUseCase(
        repository: CurrentUserRepository
    ): SetOnboardingShowedUseCase = SetOnboardingShowedUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchAllUsersUseCase(
        repository: CurrentUserRepository,
        userRepository: UserRepository
    ): FetchAllUsersUseCase = FetchAllUsersUseCaseImpl(
        currentUserRepository = repository,
//        userRepository = userRepository
    )

    @Provides
    fun provideFetchAllTripsUseCase(
        repository: OshRepository
    ): FetchAllTripsUseCase = FetchAllTripsUseCaseImpl(
        oshRepository = repository
    )

    @Provides
    fun provideFetchAllTripsByIdUseCase(
        repository: OshRepository
    ): FetchAllTripsByIdUseCase = FetchAllTripsByIdUseCaseImpl(
        oshRepository = repository
    )

    @Provides
    fun provideFetchAllSavedToursUseCase(
        repository: OshRepository
    ): FetchAllSavedToursUseCase = FetchAllSavedToursUseCaseImpl(
        oshRepository = repository
    )

    @Provides
    fun provideIsTourSavedUseCase(
        repository: OshRepository
    ): IsTourSavedUseCase = IsTourSavedUseCaseImpl(
        oshRepository = repository
    )

    @Provides
    fun provideTourOperatorUseCase(
        repository: OshRepository
    ): TourOperatorUseCase = TourOperatorUseCaseImpl(
        oshRepository = repository
    )
@Provides
    fun provideSearchByQueryTripsUseCase(
        repository: OshRepository
    ): SearchByQueryTripsUseCase = SearchByQueryTripsUseCaseImpl(
        repository = repository
    )


}