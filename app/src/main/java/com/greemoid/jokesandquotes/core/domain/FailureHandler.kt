package com.greemoid.jokesandquotes.core.domain

import com.greemoid.jokesandquotes.core.presentation.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}

