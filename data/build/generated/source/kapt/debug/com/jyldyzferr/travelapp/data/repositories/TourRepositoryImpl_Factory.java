package com.jyldyzferr.travelapp.data.repositories;

import com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource;
import com.jyldyzferr.travelapp.data.cloud.service.TourService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TourRepositoryImpl_Factory implements Factory<TourRepositoryImpl> {
  private final Provider<TourCacheDataSource> cacheDataSourceProvider;

  private final Provider<TourService> tourServiceProvider;

  public TourRepositoryImpl_Factory(Provider<TourCacheDataSource> cacheDataSourceProvider,
      Provider<TourService> tourServiceProvider) {
    this.cacheDataSourceProvider = cacheDataSourceProvider;
    this.tourServiceProvider = tourServiceProvider;
  }

  @Override
  public TourRepositoryImpl get() {
    return newInstance(cacheDataSourceProvider.get(), tourServiceProvider.get());
  }

  public static TourRepositoryImpl_Factory create(
      Provider<TourCacheDataSource> cacheDataSourceProvider,
      Provider<TourService> tourServiceProvider) {
    return new TourRepositoryImpl_Factory(cacheDataSourceProvider, tourServiceProvider);
  }

  public static TourRepositoryImpl newInstance(TourCacheDataSource cacheDataSource,
      TourService tourService) {
    return new TourRepositoryImpl(cacheDataSource, tourService);
  }
}
