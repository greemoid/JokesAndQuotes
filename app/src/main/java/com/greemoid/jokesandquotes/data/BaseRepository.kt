package com.greemoid.jokesandquotes.data

import android.util.Log
import com.greemoid.jokesandquotes.core.data.CommonRepository
import com.greemoid.jokesandquotes.core.data.DataFetcher
import com.greemoid.jokesandquotes.core.data.cache.CacheDataSource
import com.greemoid.jokesandquotes.core.data.cache.CachedData
import com.greemoid.jokesandquotes.core.data.net.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseRepository(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
    private val cachedJoke: CachedData,
) : CommonRepository {

    private var currentDataSource: DataFetcher = cloudDataSource

    override suspend fun getItem(): CommonDataModel =
        withContext(Dispatchers.IO) {
            try {
                val joke = currentDataSource.getData()
                cachedJoke.saveJoke(joke)
                Log.d("REPOSITORY", joke.toString())
                return@withContext joke
            } catch (e: Exception) {
                cachedJoke.clear()
                Log.d("REPOSITORY", e.toString())
                throw e
            }
        }

    override suspend fun changeStatus(): CommonDataModel {
        return cachedJoke.change(cacheDataSource)
    }

    override fun chooseDataSource(cached: Boolean) {
        currentDataSource = if (cached) cacheDataSource else cloudDataSource
    }

}
