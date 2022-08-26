package com.greemoid.jokesandquotes.presentation

import androidx.annotation.DrawableRes
import com.greemoid.jokesandquotes.R
import com.greemoid.jokesandquotes.core.presentation.Communication

class BaseCommonUiModel(text: String, punchline: String) : CommonUiModel(text, punchline) {
    override fun getIconResId(): Int {
        return R.drawable.ic_favorite_border
    }
}

class FavoriteCommonUiModel(text: String, punchline: String) : CommonUiModel(text, punchline) {
    override fun getIconResId(): Int {
        return R.drawable.ic_favorite_filled
    }
}

class FailedCommonUiModel(private val text: String) : CommonUiModel(text, "") {
    override fun text(): String = text
    override fun getIconResId(): Int = 0
    override fun show(communication: Communication) =
        communication.showState(State.Failed(text(), getIconResId()))
}

abstract class CommonUiModel(
    private val first: String,
    private val second: String,
) {

    protected open fun text() = "$first\n$second"

    @DrawableRes
    protected abstract fun getIconResId(): Int

    open fun show(communication: Communication) =
        communication.showState(State.Initial(text(), getIconResId()))
}