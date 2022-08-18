package com.greemoid.jokesandquotes

import androidx.annotation.DrawableRes

class BaseJokeUiModel(text: String, punchline: String) : JokeUiModel(text, punchline) {
    override fun getIconResId(): Int {
        return R.drawable.ic_favorite_border
    }
}

class FavoriteJokeUiModel(text: String, punchline: String) : JokeUiModel(text, punchline) {
    override fun getIconResId(): Int {
        return R.drawable.ic_favorite_filled
    }
}

class FailedJokeUiModel(text: String) : JokeUiModel(text, "") {
    override fun getIconResId(): Int {
        return 0
    }
}

abstract class JokeUiModel(
    private val text: String,
    private val punchline: String,
) {

    protected fun text() = "$text \n$punchline"

    @DrawableRes
    protected abstract fun getIconResId(): Int

    fun map(callback: DataCallback) = callback.run {
        provideText(text())
        provideIconRes(getIconResId())
    }
}