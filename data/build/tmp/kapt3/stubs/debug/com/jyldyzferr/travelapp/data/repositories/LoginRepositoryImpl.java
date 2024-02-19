package com.jyldyzferr.travelapp.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/jyldyzferr/travelapp/data/repositories/LoginRepositoryImpl;", "Lcom/jyldyzferr/travelapp/domain/repositories/LoginRepository;", "service", "Lcom/jyldyzferr/travelapp/data/cloud/service/LoginService;", "(Lcom/jyldyzferr/travelapp/data/cloud/service/LoginService;)V", "signIn", "Lcom/jyldyzferr/travelapp/domain/common/Result;", "Lcom/jyldyzferr/travelapp/domain/models/UserDomain;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/jyldyzferr/travelapp/domain/models/CreateResponseDomain;", "name", "lastName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class LoginRepositoryImpl implements com.jyldyzferr.travelapp.domain.repositories.LoginRepository {
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cloud.service.LoginService service = null;
    
    @javax.inject.Inject
    public LoginRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cloud.service.LoginService service) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object signIn(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<com.jyldyzferr.travelapp.domain.models.UserDomain>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object signUp(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<com.jyldyzferr.travelapp.domain.models.CreateResponseDomain>> $completion) {
        return null;
    }
}