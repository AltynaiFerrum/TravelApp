package com.jyldyzferr.travelapp.data.cloud.source;

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
public final class TourCloudDataSourceImpl_Factory implements Factory<TourCloudDataSourceImpl> {
  private final Provider<TourService> tourServiceProvider;

  public TourCloudDataSourceImpl_Factory(Provider<TourService> tourServiceProvider) {
    this.tourServiceProvider = tourServiceProvider;
  }

  @Override
  public TourCloudDataSourceImpl get() {
    return newInstance(tourServiceProvider.get());
  }

  public static TourCloudDataSourceImpl_Factory create(Provider<TourService> tourServiceProvider) {
    return new TourCloudDataSourceImpl_Factory(tourServiceProvider);
  }

  public static TourCloudDataSourceImpl newInstance(TourService tourService) {
    return new TourCloudDataSourceImpl(tourService);
  }
}
