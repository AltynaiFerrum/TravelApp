package com.jyldyzferr.travelapp.data.cache.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/jyldyzferr/travelapp/data/cache/database/TourDatabase;", "Landroidx/room/RoomDatabase;", "()V", "tourDao", "Lcom/jyldyzferr/travelapp/data/cache/dao/TourDao;", "data_debug"})
@androidx.room.Database(entities = {com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.jyldyzferr.travelapp.data.cache.database.Converters.class})
public abstract class TourDatabase extends androidx.room.RoomDatabase {
    
    public TourDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.jyldyzferr.travelapp.data.cache.dao.TourDao tourDao();
}