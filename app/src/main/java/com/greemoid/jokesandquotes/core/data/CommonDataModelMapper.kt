package com.greemoid.jokesandquotes.core.data

import com.greemoid.jokesandquotes.data.cache.JokeRealmModel

interface CommonDataModelMapper<T> {
    fun map(id: Int, first: String, second: String, cached: Boolean): T
}

class CommonRealmMapper : CommonDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): JokeRealmModel =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = first
            joke.punchline = second
        }
}