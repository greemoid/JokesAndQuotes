package com.greemoid.jokesandquotes.core.data.net

import com.greemoid.jokesandquotes.core.data.DataFetcher
import com.greemoid.jokesandquotes.data.CommonDataModel


interface CloudDataSource : DataFetcher {

    override suspend fun getData(): CommonDataModel

}