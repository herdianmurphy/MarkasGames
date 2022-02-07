package com.markas.games.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ps_games")
data class PsGamesEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var gamesId: Int,

    @ColumnInfo(name = "slug")
    var slug: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "background_image")
    var backgroundImage: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "ratings_count")
    var ratingsCount: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
