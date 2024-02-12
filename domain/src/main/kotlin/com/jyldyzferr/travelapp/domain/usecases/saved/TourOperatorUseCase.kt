package com.jyldyzferr.travelapp.domain.usecases.saved

import com.jyldyzferr.travelapp.domain.models.ToursNewDomain
import com.jyldyzferr.travelapp.domain.repositories.TourRepository


interface TourOperatorUseCase {

    suspend fun saveTour(tour: ToursNewDomain)

    suspend fun removeTour(tourId: String)
}

class TourOperatorUseCaseImpl constructor(
    private val tourRepository: TourRepository
): TourOperatorUseCase {
    override suspend fun saveTour(tour: ToursNewDomain) {
        tourRepository.addNewTour(tour)
    }

    override suspend fun removeTour(tourId: String) {
        tourRepository.deleteTourById(tourId)
    }
}