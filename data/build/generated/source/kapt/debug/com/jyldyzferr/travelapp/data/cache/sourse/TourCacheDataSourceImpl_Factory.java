package com.jyldyzferr.travelapp.data.cache.sourse;

import com.jyldyzferr.travelapp.data.cache.dao.TourDao;
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
public final class TourCacheDataSourceImpl_Factory implements Factory<TourCacheDataSourceImpl> {
  private final Provider<TourDao> tourDaoProvider;

  public TourCacheDataSourceImpl_Factory(Provider<TourDao> tourDaoProvider) {
    this.tourDaoProvider = tourDaoProvider;
  }

  @Override
  public TourCacheDataSourceImpl get() {
    return newInstance(tourDaoProvider.get());
  }

  public static TourCacheDataSourceImpl_Factory create(Provider<TourDao> tourDaoProvider) {
    return new TourCacheDataSourceImpl_Factory(tourDaoProvider);
  }

  public static TourCacheDataSourceImpl newInstance(TourDao tourDao) {
    return new TourCacheDataSourceImpl(tourDao);
  }
}
