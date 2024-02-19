package com.jyldyzferr.travelapp.data.cloud.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cloud/service/LoginService;", "", "signIn", "Lretrofit2/Response;", "Lcom/jyldyzferr/travelapp/data/cloud/models/UserResponse;", "params", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/jyldyzferr/travelapp/data/cloud/models/CreateResponse;", "Lcom/jyldyzferr/travelapp/data/cloud/models/SignUpParams;", "(Lcom/jyldyzferr/travelapp/data/cloud/models/SignUpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface LoginService {
    
    @retrofit2.http.GET(value = "Users")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signIn(@retrofit2.http.Query(value = "where")
    @org.jetbrains.annotations.NotNull
    java.lang.String params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.jyldyzferr.travelapp.data.cloud.models.UserResponse>> $completion);
    
    @retrofit2.http.POST(value = "Users")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signUp(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cloud.models.SignUpParams params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.jyldyzferr.travelapp.data.cloud.models.CreateResponse>> $completion);
}