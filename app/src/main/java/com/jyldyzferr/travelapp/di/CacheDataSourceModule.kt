package com.jyldyzferr.travelapp.di

import com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource
import com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CacheDataSourceModule {

    @Binds
    fun bindTourCacheDataSource(
        implementation: TourCacheDataSourceImpl
    ): TourCacheDataSource

}