package com.greemoid.jokesandquotes.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.greemoid.jokesandquotes.presentation.State

interface CommonViewModel {
    fun getItem()
    fun changeItemStatus()
    fun chooseFavorite(favorites: Boolean)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
}