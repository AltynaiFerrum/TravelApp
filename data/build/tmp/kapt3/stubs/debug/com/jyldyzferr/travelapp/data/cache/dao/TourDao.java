package com.jyldyzferr.travelapp.data.cache.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\b\u001a\u00020\tH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cache/dao/TourDao;", "", "addNewTour", "", "tour", "Lcom/jyldyzferr/travelapp/data/cache/models/TourDetailsCache;", "(Lcom/jyldyzferr/travelapp/data/cache/models/TourDetailsCache;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTourById", "tourId", "", "fetchAllSavedTours", "Lkotlinx/coroutines/flow/Flow;", "", "isTourSaved", "", "data_debug"})
@androidx.room.Dao
public abstract interface TourDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addNewTour(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache tour, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM tours_table WHERE id = :tourId")
    public abstract void deleteTourById(@org.jetbrains.annotations.NotNull
    java.lang.String tourId);
    
    @androidx.room.Query(value = "SELECT * FROM tours_table")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache>> fetchAllSavedTours();
    
    @androidx.room.Query(value = "SELECT EXISTS (SELECT 1 FROM tours_table WHERE id = :tourId) ")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isTourSaved(@org.jetbrains.annotations.NotNull
    java.lang.String tourId);
}