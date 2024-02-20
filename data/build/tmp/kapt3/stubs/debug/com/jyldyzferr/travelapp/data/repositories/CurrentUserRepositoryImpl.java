package com.jyldyzferr.travelapp.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/jyldyzferr/travelapp/data/repositories/CurrentUserRepositoryImpl;", "Lcom/jyldyzferr/travelapp/domain/repositories/CurrentUserRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "clearCurrentUser", "", "clearOnboarding", "fetchCurrentUser", "Lcom/jyldyzferr/travelapp/domain/models/UserDomain;", "isOnboardingPassed", "", "saveCurrentUser", "user", "setOnboardingShowed", "data_debug"})
public final class CurrentUserRepositoryImpl implements com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy sharedPreferences$delegate = null;
    
    @javax.inject.Inject
    public CurrentUserRepositoryImpl(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    @java.lang.Override
    public void saveCurrentUser(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.domain.models.UserDomain user) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.jyldyzferr.travelapp.domain.models.UserDomain fetchCurrentUser() {
        return null;
    }
    
    @java.lang.Override
    public void clearCurrentUser() {
    }
    
    @java.lang.Override
    public boolean isOnboardingPassed() {
        return false;
    }
    
    @java.lang.Override
    public void setOnboardingShowed() {
    }
    
    @java.lang.Override
    public void clearOnboarding() {
    }
}