package com.jyldyzferr.travelapp.domain.usecases.tours

import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.TourRepository

interface FetchAllTripsUseCase {
    suspend operator fun  invoke(): List<ToursNewDomain>
}

class FetchAllTripsUseCaseImpl constructor(
    private val tourRepository: TourRepository,
):FetchAllTripsUseCase{
    override suspend fun invoke(): List<ToursNewDomain> {
        val trips = tourRepository.fetchAllTours().data
        return trips ?: listOf()
    }
}

