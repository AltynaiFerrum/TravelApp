package com.jyldyzferr.travelapp.data.repositories;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class CurrentUserRepositoryImpl_Factory implements Factory<CurrentUserRepositoryImpl> {
  private final Provider<Context> contextProvider;

  public CurrentUserRepositoryImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CurrentUserRepositoryImpl get() {
    return newInstance(contextProvider.get());
  }

  public static CurrentUserRepositoryImpl_Factory create(Provider<Context> contextProvider) {
    return new CurrentUserRepositoryImpl_Factory(contextProvider);
  }

  public static CurrentUserRepositoryImpl newInstance(Context context) {
    return new CurrentUserRepositoryImpl(context);
  }
}
