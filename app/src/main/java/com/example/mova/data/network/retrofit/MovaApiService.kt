package com.example.mova.data.network.retrofit

import com.example.mova.data.network.model.ExploreMovieItem
import retrofit2.http.GET
import retrofit2.http.Path

interface MovaApiService{

//    @Headers(
//        "X-RapidAPI-Key: 30edcbded6msh644dde905c635d5p1a78ddjsn76651b57e032",
//        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"
//    )
    @GET("/")
    suspend fun getMovies(): List<ExploreMovieItem>

    @GET("{searchInput}")
    suspend fun getMovieById(@Path("searchInput") searchInput: String): ExploreMovieItem
}