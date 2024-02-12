package com.jyldyzferr.travelapp.domain.usecases.saved

import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.TourRepository
import kotlinx.coroutines.flow.Flow

interface FetchAllSavedToursUseCase {
    operator fun invoke(): Flow<List<ToursNewDomain>>
}

class FetchAllSavedToursUseCaseImpl constructor(
    private val tourRepository: TourRepository
): FetchAllSavedToursUseCase
{
    override fun invoke(): Flow<List<ToursNewDomain>> {
        return tourRepository.fetchAllSavedTours()
    }
}