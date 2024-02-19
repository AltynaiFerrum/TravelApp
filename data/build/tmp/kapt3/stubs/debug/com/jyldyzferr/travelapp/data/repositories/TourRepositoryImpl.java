package com.jyldyzferr.travelapp.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u0011H\u0016J\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001b\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/jyldyzferr/travelapp/data/repositories/TourRepositoryImpl;", "Lcom/jyldyzferr/travelapp/domain/repositories/TourRepository;", "cacheDataSource", "Lcom/jyldyzferr/travelapp/data/cache/sourse/TourCacheDataSource;", "tourService", "Lcom/jyldyzferr/travelapp/data/cloud/service/TourService;", "(Lcom/jyldyzferr/travelapp/data/cache/sourse/TourCacheDataSource;Lcom/jyldyzferr/travelapp/data/cloud/service/TourService;)V", "addNewTour", "", "tour", "Lcom/jyldyzferr/travelapp/domain/models/ToursNewDomain;", "(Lcom/jyldyzferr/travelapp/domain/models/ToursNewDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTourById", "tourId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllSavedTours", "Lkotlinx/coroutines/flow/Flow;", "", "fetchAllTours", "Lcom/jyldyzferr/travelapp/domain/common/Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToursById", "objectId", "isTourSavedFlow", "", "searchByQuery", "query", "data_debug"})
public final class TourRepositoryImpl implements com.jyldyzferr.travelapp.domain.repositories.TourRepository {
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource cacheDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cloud.service.TourService tourService = null;
    
    @javax.inject.Inject
    public TourRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource cacheDataSource, @org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cloud.service.TourService tourService) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchAllTours(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<java.util.List<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchToursById(@org.jetbrains.annotations.NotNull
    java.lang.String objectId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jyldyzferr.travelapp.domain.common.Result<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>> fetchAllSavedTours() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object searchByQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isTourSavedFlow(@org.jetbrains.annotations.NotNull
    java.lang.String tourId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addNewTour(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.domain.models.ToursNewDomain tour, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteTourById(@org.jetbrains.annotations.NotNull
    java.lang.String tourId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}