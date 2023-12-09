package com.example.mova.ui.features.explore.view

import com.example.mova.data.network.model.ExploreMovieItem

sealed interface SearchUiState{
    data class SearchSuccess(val searchMovie: ExploreMovieItem): SearchUiState
    object TopSearch: SearchUiState
    object Loading: SearchUiState
    object Error: SearchUiState
}