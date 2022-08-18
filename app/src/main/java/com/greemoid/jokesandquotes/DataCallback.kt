package com.greemoid.jokesandquotes

import androidx.annotation.DrawableRes

interface DataCallback {

    fun provideText(text: String)

    fun provideIconRes(@DrawableRes id: Int)
}