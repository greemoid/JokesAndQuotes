package com.greemoid.jokesandquotes.data.net

import com.greemoid.jokesandquotes.data.NewJokeServerModel
import retrofit2.http.GET

interface JokeService {

    @GET("https://v2.jokeapi.dev/joke/Any")
    suspend fun getJoke(): NewJokeServerModel
}

