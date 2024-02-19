package com.jyldyzferr.travelapp.data.cloud.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cloud/source/TourCloudDataSource;", "", "fetchAllTours", "", "Lcom/jyldyzferr/travelapp/data/cloud/models/tours/ToursNewCloud;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToursById", "objectId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchByQuery", "Lcom/jyldyzferr/travelapp/domain/models/ToursNewDomain;", "query", "data_debug"})
public abstract interface TourCloudDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object fetchAllTours(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object fetchToursById(@org.jetbrains.annotations.NotNull
    java.lang.String objectId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchByQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>> $completion);
}