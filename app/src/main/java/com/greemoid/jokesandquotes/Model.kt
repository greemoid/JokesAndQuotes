package com.greemoid.jokesandquotes

import android.service.carrier.CarrierMessagingService

interface Model {

    fun getJoke()

    fun init(callback: ResultCallback)

    fun clear()
}

