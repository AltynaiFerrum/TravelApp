package com.jyldyzferr.travelapp.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/jyldyzferr/travelapp/data/repositories/UserRepositoryImpl;", "Lcom/jyldyzferr/travelapp/domain/repositories/UserRepository;", "service", "Lcom/jyldyzferr/travelapp/data/cloud/service/UserService;", "(Lcom/jyldyzferr/travelapp/data/cloud/service/UserService;)V", "deleteUserById", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllUsers", "Lcom/jyldyzferr/travelapp/domain/common/Result;", "", "Lcom/jyldyzferr/travelapp/domain/models/UserDomain;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserById", "updateUser", "(Lcom/jyldyzferr/travelapp/domain/models/UserDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class UserRepositoryImpl implements com.jyldyzferr.travelapp.domain.repositories.UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cloud.service.UserService service = null;
    
    @javax.inject.Inject
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cloud.service.UserService service) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchUserById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<com.jyldyzferr.travelapp.domain.models.UserDomain>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<java.util.List<com.jyldyzferr.travelapp.domain.models.UserDomain>>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteUserById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.domain.models.UserDomain updateUser, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<com.jyldyzferr.travelapp.domain.models.UserDomain>> $completion) {
        return null;
    }
}