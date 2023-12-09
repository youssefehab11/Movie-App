package com.example.mova.ui.features.explore.view

import com.example.mova.data.network.model.ExploreMovieItem

sealed interface ExploreUiState{
    data class Success(val exploreMovies: List<ExploreMovieItem>): ExploreUiState
    object Loading: ExploreUiState
    object Error: ExploreUiState
}