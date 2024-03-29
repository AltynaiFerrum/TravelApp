package com.jyldyzferr.travelapp.di

import com.jyldyzferr.travelapp.data.cache.sourse.FetchFromBookingCloudDataSource
import com.jyldyzferr.travelapp.data.cache.sourse.FetchFromBookingCloudDataSourceImpl
import com.jyldyzferr.travelapp.data.cloud.source.TourCloudDataSource
import com.jyldyzferr.travelapp.data.cloud.source.TourCloudDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CloudDataSourceModule {
    @Binds
    fun bindOshCloudDataSource(
        implementation: TourCloudDataSourceImpl
    ): TourCloudDataSource

    @Binds
    fun bindFetchFromBookingCloudDataSource(
        implementation: FetchFromBookingCloudDataSourceImpl
    ): FetchFromBookingCloudDataSource

}