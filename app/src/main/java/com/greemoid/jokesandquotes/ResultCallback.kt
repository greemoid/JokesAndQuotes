package com.greemoid.jokesandquotes

interface ResultCallback {

    fun provideSuccess(data: Joke)

    fun provideError(error: JokeFailure)
}