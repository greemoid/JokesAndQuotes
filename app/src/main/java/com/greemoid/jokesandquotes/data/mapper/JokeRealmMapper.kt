package com.greemoid.jokesandquotes.data.mapper

import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.data.cache.JokeRealmModel

class JokeRealmMapper : CommonDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): JokeRealmModel =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = first
            joke.punchline = second
        }

}