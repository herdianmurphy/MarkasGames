package com.markas.games.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genres(
    val id: Int,
    val name: String,
    val imageBackground: String,

) : Parcelable