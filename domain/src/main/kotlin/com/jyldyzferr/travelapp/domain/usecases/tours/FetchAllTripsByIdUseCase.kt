package com.jyldyzferr.travelapp.domain.usecases.tours

import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.TourRepository

interface FetchAllTripsByIdUseCase {
    suspend operator fun invoke (objectId: String) : Result<ToursNewDomain>
}

class FetchAllTripsByIdUseCaseImpl constructor(
    private val tourRepository: TourRepository,
) : FetchAllTripsByIdUseCase{
    override suspend fun invoke(objectId: String): Result<ToursNewDomain> {
        return tourRepository.fetchToursById(objectId)
    }
}