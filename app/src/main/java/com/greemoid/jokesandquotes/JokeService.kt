package com.greemoid.jokesandquotes

import retrofit2.Call
import retrofit2.http.GET


interface JokeService {

    @GET("https://nova-joke-api.netlify.app/.netlify/functions/index/api/random")
    fun getJoke(): Call<JokeDTO>

}

interface ServiceCallback {

    fun returnSuccess(data: JokeDTO)

    fun returnError(type: ErrorType)

}

enum class ErrorType {
    NO_CONNECTION,
    OTHER
}