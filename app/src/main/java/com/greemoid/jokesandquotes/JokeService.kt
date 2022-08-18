package com.greemoid.jokesandquotes

import retrofit2.Call
import retrofit2.http.GET


interface JokeService {

    @GET("https://nova-joke-api.netlify.app/.netlify/functions/index/api/random")
    fun getJoke(): Call<JokeServerModel>

}

interface JokeCloudCallback {

    fun provide(joke: Joke)

    fun fail(error: ErrorType)

}


enum class ErrorType {
    NO_CONNECTION,
    SERVICE_UNAVAILABLE
}