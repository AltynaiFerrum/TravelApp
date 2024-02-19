package com.jyldyzferr.travelapp.data.cloud.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cloud/service/TourService;", "", "fetchAllTours", "Lcom/jyldyzferr/travelapp/data/cloud/models/tours/ToursNewResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTourById", "params", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchByQuery", "query", "data_debug"})
public abstract interface TourService {
    
    @retrofit2.http.GET(value = "Osh")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object fetchAllTours(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewResponse> $completion);
    
    @retrofit2.http.GET(value = "Osh")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object fetchTourById(@retrofit2.http.Query(value = "where")
    @org.jetbrains.annotations.NotNull
    java.lang.String params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewResponse> $completion);
    
    @retrofit2.http.GET(value = "Osh")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchByQuery(@retrofit2.http.Query(value = "where")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewResponse> $completion);
}