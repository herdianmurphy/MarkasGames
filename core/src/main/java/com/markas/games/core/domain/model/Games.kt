package com.markas.games.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val id: Int,
    val slug: String,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val rating: Double,
    val ratingsCount: Double,
    val isFavorite: Boolean
) : Parcelable