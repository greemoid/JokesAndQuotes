package com.greemoid.jokesandquotes.core.data.cache

import com.greemoid.jokesandquotes.core.data.ChangeCommonItem

interface CachedData : ChangeCommonItem {
    fun saveJoke(joke: ChangeCommonItem)
    fun clear()
}

