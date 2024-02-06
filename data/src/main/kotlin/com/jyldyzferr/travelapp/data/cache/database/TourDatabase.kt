package com.jyldyzferr.travelapp.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jyldyzferr.travelapp.data.cache.dao.TourDao
import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache
import java.lang.reflect.Type


@Database(entities = [
    TourDetailsCache::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class TourDatabase: RoomDatabase() {

    abstract fun tourDao(): TourDao

}

object Converters{
    @TypeConverter
    fun fromString(value: String?) : List<String> {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    fun fromList(list: List<String?>?) : String {
        val gson= Gson()
        return gson.toJson(list)
    }
}

