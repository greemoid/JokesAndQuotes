package com.greemoid.jokesandquotes

class Joke(
    private val text: String,
    private val punchline: String
) {

    fun getJoke() = "$text \n$punchline"
}