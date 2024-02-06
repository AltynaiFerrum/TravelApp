//package com.jyldyzferr.travelapp.data.repositories
//
//import com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource
//import com.jyldyzferr.travelapp.data.mappers.toCache
//import com.jyldyzferr.travelapp.data.mappers.toDomain
//import com.jyldyzferr.travelapp.domain.models.TourDetailsDomain
//import com.jyldyzferr.travelapp.domain.repositories.TourRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//import javax.inject.Inject
//
//class TourRepositoryImpl @Inject constructor(
////    private val cacheDataSource: TourCacheDataSource,
//) : TourRepository {
//    override suspend fun addNewTour(tour: TourDetailsDomain) {
//        cacheDataSource.addNewTour(tour = tour.toCache())
//    }
//
//    override suspend fun deleteTourById(movieId: String) {
//        cacheDataSource.deleteTourById(movieId)
//    }
//
//    override fun fetchAllSavedTours(): Flow<List<TourDetailsDomain>> {
//        return cacheDataSource.fetchAllSavedTours().map { it.map {it.toDomain() }}
//    }
//
////    override fun isTourSavedFlow(movieId: String): Flow<Boolean> {
////        return cacheDataSource.isTourSavedFlow(movieId)
////    }
//}
