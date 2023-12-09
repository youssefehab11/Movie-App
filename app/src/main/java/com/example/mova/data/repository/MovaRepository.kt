package com.example.mova.data.repository

import com.example.mova.data.network.model.ExploreMovieItem
import com.example.mova.data.network.retrofit.MovaApiService
import javax.inject.Inject

class MovaRepository @Inject constructor(
    private val movaApiService: MovaApiService
) {
    suspend fun getMovies(): List<ExploreMovieItem>{
        return  movaApiService.getMovies()
    }

    suspend fun getMovieById(inputSearch: String): ExploreMovieItem{
        return movaApiService.getMovieById(inputSearch)
    }
}