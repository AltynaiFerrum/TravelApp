package com.jyldyzferr.travelapp.data.cloud.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cloud/source/TourCloudDataSourceImpl;", "Lcom/jyldyzferr/travelapp/data/cloud/source/TourCloudDataSource;", "tourService", "Lcom/jyldyzferr/travelapp/data/cloud/service/TourService;", "(Lcom/jyldyzferr/travelapp/data/cloud/service/TourService;)V", "fetchAllTours", "", "Lcom/jyldyzferr/travelapp/data/cloud/models/tours/ToursNewCloud;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToursById", "objectId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchByQuery", "Lcom/jyldyzferr/travelapp/domain/models/ToursNewDomain;", "query", "data_debug"})
public final class TourCloudDataSourceImpl implements com.jyldyzferr.travelapp.data.cloud.source.TourCloudDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.jyldyzferr.travelapp.data.cloud.service.TourService tourService = null;
    
    @javax.inject.Inject
    public TourCloudDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.jyldyzferr.travelapp.data.cloud.service.TourService tourService) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchAllTours(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fetchToursById(@org.jetbrains.annotations.NotNull
    java.lang.String objectId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.data.cloud.models.tours.ToursNewCloud>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object searchByQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.jyldyzferr.travelapp.domain.models.ToursNewDomain>> $completion) {
        return null;
    }
}