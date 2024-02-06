package com.jyldyzferr.travelapp.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "tours_table"
)
data class TourDetailsCache(
    @PrimaryKey
    val id: String,
    @ColumnInfo("createdAt")
    val createdAt: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("image")
    val image: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("updatedAt")
    val updatedAt: String,
    @ColumnInfo("location")
    val location: String,
    @ColumnInfo("price")
    val price: String,
    @ColumnInfo("rating")
    val rating: Int,
)

