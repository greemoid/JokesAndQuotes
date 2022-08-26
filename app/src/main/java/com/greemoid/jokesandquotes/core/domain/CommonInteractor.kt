package com.greemoid.jokesandquotes.core.domain

import com.greemoid.jokesandquotes.domain.CommonItem

interface CommonInteractor {

    suspend fun getItem(): CommonItem
    suspend fun changeFavorites(): CommonItem
    fun getFavorites(favorites: Boolean)

}