package com.greemoid.jokesandquotes.presentation

import androidx.annotation.DrawableRes
import com.greemoid.jokesandquotes.core.presentation.ShowImage
import com.greemoid.jokesandquotes.core.presentation.ShowText
import com.greemoid.jokesandquotes.core.presentation.ShowView

sealed class State {
    protected abstract val type: Int

    companion object {
        const val INITIAL = 0
        const val PROGRESS = 1
        const val FAILED = 2
    }

    fun isType(type: Int): Boolean = this.type == type

    fun show(
        progress: ShowView,
        button: ShowView,
        textView: ShowText,
        imageView: ShowImage,
    ) {
        show(progress, button)
        show(textView, imageView)
    }


    protected open fun show(progress: ShowView, button: ShowView) {}
    protected open fun show(textView: ShowText, imageView: ShowImage) {}

    object Progress : State() {
        override val type: Int = PROGRESS
        override fun show(progress: ShowView, button: ShowView) {
            progress.show(true)
            button.show(false)
        }
    }

    abstract class Info(private val text: String, private val id: Int) : State() {
        override fun show(progress: ShowView, button: ShowView) {
            progress.show(false)
            button.show(true)
        }

        override fun show(textView: ShowText, imageView: ShowImage) {
            textView.show(text)
            imageView.show(id)
        }
    }

    class Initial(text: String, @DrawableRes id: Int) : Info(text, id) {
        override val type: Int = INITIAL
    }

    class Failed(text: String, @DrawableRes id: Int) : Info(text, id) {
        override val type: Int = FAILED
    }
}
