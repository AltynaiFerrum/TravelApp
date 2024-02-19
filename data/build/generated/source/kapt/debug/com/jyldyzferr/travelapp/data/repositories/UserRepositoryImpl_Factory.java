package com.jyldyzferr.travelapp.data.repositories;

import com.jyldyzferr.travelapp.data.cloud.service.UserService;
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
public final class UserRepositoryImpl_Factory implements Factory<UserRepositoryImpl> {
  private final Provider<UserService> serviceProvider;

  public UserRepositoryImpl_Factory(Provider<UserService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public UserRepositoryImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static UserRepositoryImpl_Factory create(Provider<UserService> serviceProvider) {
    return new UserRepositoryImpl_Factory(serviceProvider);
  }

  public static UserRepositoryImpl newInstance(UserService service) {
    return new UserRepositoryImpl(service);
  }
}
