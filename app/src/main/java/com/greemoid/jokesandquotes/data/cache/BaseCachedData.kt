package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.ChangeCommonItem
import com.greemoid.jokesandquotes.core.data.ChangeStatus
import com.greemoid.jokesandquotes.core.data.cache.CachedData
import com.greemoid.jokesandquotes.data.CommonDataModel

class BaseCachedData : CachedData {

    private var cached: ChangeCommonItem = ChangeCommonItem.Empty()

    override fun saveJoke(joke: ChangeCommonItem) {
        cached = joke
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
        return cached.change(changeStatus)
    }

}