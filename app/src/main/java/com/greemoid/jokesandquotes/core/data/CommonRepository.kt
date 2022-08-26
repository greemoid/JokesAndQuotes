package com.greemoid.jokesandquotes.core.data

import com.greemoid.jokesandquotes.data.CommonDataModel

interface CommonRepository {
    suspend fun getItem(): CommonDataModel
    suspend fun changeStatus(): CommonDataModel
    fun chooseDataSource(cached: Boolean)
}

