package com.jyldyzferr.travelapp.data.repositories;

import com.jyldyzferr.travelapp.data.cloud.service.LoginService;
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
public final class LoginRepositoryImpl_Factory implements Factory<LoginRepositoryImpl> {
  private final Provider<LoginService> serviceProvider;

  public LoginRepositoryImpl_Factory(Provider<LoginService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public LoginRepositoryImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static LoginRepositoryImpl_Factory create(Provider<LoginService> serviceProvider) {
    return new LoginRepositoryImpl_Factory(serviceProvider);
  }

  public static LoginRepositoryImpl newInstance(LoginService service) {
    return new LoginRepositoryImpl(service);
  }
}
