package com.greemoid.jokesandquotes.domain

import android.util.Log
import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.core.data.CommonRepository
import com.greemoid.jokesandquotes.core.domain.CommonInteractor
import com.greemoid.jokesandquotes.core.domain.FailureHandler

class BaseInteractor(
    private val repository: CommonRepository,
    private val failureHandler: FailureHandler,
    private val mapper: CommonDataModelMapper<CommonItem.Success>,
) : CommonInteractor {
    override suspend fun getItem(): CommonItem {
        return try {
            val joke = repository.getItem().map(mapper)
            CommonItem.Success(joke.firstText, joke.secondText, false)
        } catch (e: Exception) {
            Log.d("INTERACTOR", "There is error")
            CommonItem.Failed(failureHandler.handle(e))
        }
    }


    override suspend fun changeFavorites(): CommonItem {
        return try {
            repository.changeStatus().map(mapper)
        } catch (e: Exception) {
            Log.d("INTERACTOR", e.toString())
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override fun getFavorites(favorites: Boolean) {
        repository.chooseDataSource(favorites)
    }
}