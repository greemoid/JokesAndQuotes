package com.greemoid.jokesandquotes.data.net

import retrofit2.http.GET

interface QuoteService {

    @GET("https://api.quotable.io/random")
    suspend fun getQuote(): QuoteServerModel
}