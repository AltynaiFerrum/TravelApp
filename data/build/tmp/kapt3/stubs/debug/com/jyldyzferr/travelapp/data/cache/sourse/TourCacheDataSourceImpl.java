package com.jyldyzferr.travelapp.data.cache.sourse;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fH\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cache/sourse/TourCacheDataSourceImpl;", "Lcom/jyldyzferr/travelapp/data/cache/sourse/TourCacheDataSource;", "tourDao", "Lcom/jyldyzferr/travelapp/data/cache/dao/TourDao;", "(Lcom/jyldyzferr/travelapp/data/cache/dao/TourDao;)V", "addNewTour", "", "tour", "Lcom/jyldyzferr/travelapp/data/cache/models/TourDetailsCache;", "(Lcom/jyldyzferr/travelapp/data/cache/models/TourDetailsCache;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTourById", "tourId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllSavedTours", "Lkotlinx/coroutines/flow/Flow;", "", "isTourSavedFlow", "", "data_debug"})
public final class TourCacheDataSourceImpl implements com.jyldyzferr.travelapp.data.cache.sourse.TourCacheDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cache.dao.TourDao tourDao = null;
    
    @javax.inject.Inject
    public TourCacheDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cache.dao.TourDao tourDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addNewTour(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache tour, @org.jetbrains.annotations.NotNull
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
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache>> fetchAllSavedTours() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isTourSavedFlow(@org.jetbrains.annotations.NotNull
    java.lang.String tourId) {
        return null;
    }
}