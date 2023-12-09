package com.example.mova.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key","a36fdbe014msh2f8095f21e8afbdp159108jsn3c6089664c47")
            .addHeader("X-RapidAPI-Host","imdb-top-100-movies.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}