package com.jyldyzferr.travelapp.domain.usecases.saved

import com.jyldyzferr.travelapp.domain.repositories.TourRepository
import kotlinx.coroutines.flow.Flow

interface IsTourSavedUseCase {
    operator fun invoke(tourId: String) : Flow<Boolean>
}
class IsTourSavedUseCaseImpl constructor(
    private val tourRepository: TourRepository
): IsTourSavedUseCase {
    override fun invoke(tourId: String): Flow<Boolean> {
        return tourRepository.isTourSavedFlow(tourId)
    }
}