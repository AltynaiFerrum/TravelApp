package com.jyldyzferr.travelapp.domain.usecases.search

import com.jyldyzferr.travelapp.domain.repositories.TourRepository
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.ToursNewDomain


interface SearchByQueryTripsUseCase {
    suspend fun searchByQuery(query: String): List<ToursNewDomain>

}

class SearchByQueryTripsUseCaseImpl constructor(
    private val repository: TourRepository
) : SearchByQueryTripsUseCase {
    override suspend fun searchByQuery(query: String): List<ToursNewDomain> {
        return repository.searchByQuery(query)
    }
}