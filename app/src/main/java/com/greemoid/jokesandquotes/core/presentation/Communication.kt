package com.greemoid.jokesandquotes.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.greemoid.jokesandquotes.presentation.State

interface Communication {

    fun showState(state: State)

    fun observe(owner: LifecycleOwner, observer: Observer<State>)

    fun isState(type: Int): Boolean

}