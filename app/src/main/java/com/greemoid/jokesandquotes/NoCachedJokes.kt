package com.greemoid.jokesandquotes

class NoCachedJokes(private val resourceManager: ResourceManager) : JokeFailure {
    override fun getMessage(): String {
        return resourceManager.getString(R.string.no_cached_jokes)
    }
}