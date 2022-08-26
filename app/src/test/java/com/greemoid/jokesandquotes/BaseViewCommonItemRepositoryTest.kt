package com.greemoid.jokesandquotes

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.greemoid.jokesandquotes.core.data.CommonRepository
import com.greemoid.jokesandquotes.domain.CommonItem
import com.greemoid.jokesandquotes.core.domain.CommonInteractor
import com.greemoid.jokesandquotes.core.presentation.Communication
import com.greemoid.jokesandquotes.presentation.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.*
import org.junit.Test

class BaseViewCommonItemRepositoryTest {

    @ExperimentalCoroutinesApi
    @Test
    fun test_get_joke_from_cloud_success(): Unit = runBlocking {
        val interactor = TestInteractor()
        val communication = TestCommunication()
        val viewModel = BaseViewModel(interactor, communication, TestCoroutineDispatcher())

        model.success = true
        viewModel.chooseFavorite(false)
        viewModel.getJoke()

        val actualText = communication.text
        val actualId = communication.id
        val expectedText = "cloudJokeText \ncloudJokePunch"
        assertEquals(expectedText, actualText)
        assertNotEquals(0, actualId)
    }

    private inner class TestCommunication : Communication {

        var text = ""
        var id = -1
        var observedCount = 0

        override fun showData(data: Pair<String, Int>) {
            text = data.first
            id = data.second
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<Pair<String, Int>>) {
           observedCount++
        }

    }

    private inner class TestInteractor : CommonInteractor {

        private val cacheJokeUiModel = BaseCommonUiModel("cachedJokeText", "cachedJokePunch")
        private val cacheJokeUiFailure = FailedCommonUiModel("cacheFailed")
        private val cloudJokeUiModel = BaseCommonUiModel("cloudJokeText", "cloudJokePunch")
        private val cloudJokeUiFailure = FailedCommonUiModel("cloudFailed")

        var success = false
        private var getFromCache = false
        private var cachedCommonItem: CommonItem? = null

        override suspend fun getItem(): CommonItem {
            if (success) {
                if (getFromCache) {
                    cacheJokeUiModel.also {
                        cachedCommonItem = it
                    }
                } else {
                    cloudJokeUiModel.also {
                        cachedCommonItem = it
                    }
                }
            } else {
                cachedCommonItem = null
                if (getFromCache) {
                    cacheJokeUiFailure
                } else {
                    cloudJokeUiFailure
                }
            }
            return
        }

        override suspend fun changeFavorites(): CommonItem {
            return cloudJokeUiFailure
        }

        override fun getFavorites(favorites: Boolean) {
            getFromCache = true
        }

    }

    private inner class TestCommonRepository : CommonRepository {

        private val cacheJokeUiModel = BaseCommonUiModel("cachedJokeText", "cachedJokePunch")
        private val cacheJokeUiFailure = FailedCommonUiModel("cacheFailed")
        private val cloudJokeUiModel = BaseCommonUiModel("cloudJokeText", "cloudJokePunch")
        private val cloudJokeUiFailure = FailedCommonUiModel("cloudFailed")

        var success = false
        private var getFromCache = false
        private var cachedJoke: CommonUiModel? = null

        override suspend fun getItem(): CommonUiModel {
            return if (success) {
                if (getFromCache) {
                    cacheJokeUiModel.also {
                        cachedJoke = it
                    }
                } else {
                    cloudJokeUiModel.also {
                        cachedJoke = it
                    }
                }
            } else {
                cachedJoke = null
                if (getFromCache) {
                    cacheJokeUiFailure
                } else {
                    cloudJokeUiFailure
                }
            }
        }

        override suspend fun changeStatus(): CommonUiModel? {
            return cloudJokeUiFailure
        }

        override fun chooseDataSource(cached: Boolean) {
            getFromCache = cached
        }

    }
}