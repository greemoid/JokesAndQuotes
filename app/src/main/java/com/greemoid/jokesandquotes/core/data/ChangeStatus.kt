package com.greemoid.jokesandquotes.core.data

import com.greemoid.jokesandquotes.data.CommonDataModel

interface ChangeStatus {
    suspend fun addOrRemove(id: Int, model: CommonDataModel): CommonDataModel
}