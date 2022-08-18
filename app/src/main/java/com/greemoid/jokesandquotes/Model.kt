package com.greemoid.jokesandquotes


interface Model {

    fun getJoke()

    fun changeJokeStatus(jokeCallback: JokeCallback)

    fun chooseDataSource(cached: Boolean)

    fun init(callback: JokeCallback)

    fun clear()
}

