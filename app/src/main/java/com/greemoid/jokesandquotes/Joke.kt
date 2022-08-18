package com.greemoid.jokesandquotes

import com.google.gson.annotations.SerializedName

class Joke(
    private val id: Int,
    private val type: String,
    private val setup: String,
    private val punchline: String
) {

    fun toBaseJoke() = BaseJokeUiModel(setup, punchline)

    fun toFavoriteJoke() = FavoriteJokeUiModel(setup, punchline)

    fun toJokeRealm(): JokeRealm{
        return JokeRealm().also {
            it.id = id
            it.type = type
            it.text = setup
            it.punchline = punchline
        }
    }

    fun change(cacheDataSource: CacheDataSource) = cacheDataSource.addOrRemove(id, this)
}