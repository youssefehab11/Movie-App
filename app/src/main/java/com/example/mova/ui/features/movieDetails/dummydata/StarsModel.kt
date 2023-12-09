package com.example.mova.ui.features.movieDetails.dummydata

import androidx.annotation.DrawableRes

enum class Types{
    Director,
    Actor
}

data class StarsModel(
    val name: String,
    @DrawableRes val image: Int,
    val type:Types
)
