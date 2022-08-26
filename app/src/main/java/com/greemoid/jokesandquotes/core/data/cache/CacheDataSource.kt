package com.greemoid.jokesandquotes.core.data.cache

import com.greemoid.jokesandquotes.core.data.ChangeStatus
import com.greemoid.jokesandquotes.core.data.DataFetcher

interface CacheDataSource : ChangeStatus, DataFetcher
