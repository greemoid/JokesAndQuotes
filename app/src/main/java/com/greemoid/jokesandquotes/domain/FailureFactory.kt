package com.greemoid.jokesandquotes.domain

import com.greemoid.jokesandquotes.core.ResourceManager
import com.greemoid.jokesandquotes.core.domain.FailureHandler
import com.greemoid.jokesandquotes.core.domain.NoCachedDataException
import com.greemoid.jokesandquotes.core.domain.NoConnectionException
import com.greemoid.jokesandquotes.core.domain.ServiceUnavailableException
import com.greemoid.jokesandquotes.core.presentation.*

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception): Failure {
        return when (e) {
            is NoConnectionException -> NoConnection(resourceManager)
            is NoCachedDataException -> NoCachedData(resourceManager)
            is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
            else -> GenericError(resourceManager)
        }
    }
}