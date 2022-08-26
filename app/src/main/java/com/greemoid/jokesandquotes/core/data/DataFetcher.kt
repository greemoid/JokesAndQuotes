package com.greemoid.jokesandquotes.core.data

import com.greemoid.jokesandquotes.data.CommonDataModel

interface DataFetcher {
    suspend fun getData(): CommonDataModel
}