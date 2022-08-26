package com.greemoid.jokesandquotes.core.presentation

import com.greemoid.jokesandquotes.R
import com.greemoid.jokesandquotes.core.ResourceManager

interface Failure {

    fun getMessage(): String

}

class NoConnection(private val resourceManager: ResourceManager) : Failure {
    override fun getMessage(): String {
        return resourceManager.getString(R.string.no_connection)
    }
}

class ServiceUnavailable(private val resourceManager: ResourceManager) : Failure {
    override fun getMessage(): String {
        return resourceManager.getString(R.string.service_unavailable)
    }

}

class GenericError(private val resourceManager: ResourceManager) : Failure {
    override fun getMessage(): String =
        resourceManager.getString(R.string.generic_fail_message)

}

class NoCachedData(private val resourceManager: ResourceManager) : Failure {
    override fun getMessage(): String {
        return resourceManager.getString(R.string.no_cached_jokes)
    }
}