package com.example.mova.data.di

import com.example.mova.data.network.interceptor.HeaderInterceptor
import com.example.mova.data.network.retrofit.MovaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule{
    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(HeaderInterceptor())
    }.build()
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://imdb-top-100-movies.p.rapidapi.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovaApiService(retrofit: Retrofit): MovaApiService{
        return retrofit.create(MovaApiService::class.java)
    }
}