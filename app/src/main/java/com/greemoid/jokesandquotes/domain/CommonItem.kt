package com.greemoid.jokesandquotes.domain

import com.greemoid.jokesandquotes.core.Mapper
import com.greemoid.jokesandquotes.core.presentation.Failure
import com.greemoid.jokesandquotes.presentation.BaseCommonUiModel
import com.greemoid.jokesandquotes.presentation.CommonUiModel
import com.greemoid.jokesandquotes.presentation.FailedCommonUiModel
import com.greemoid.jokesandquotes.presentation.FavoriteCommonUiModel

sealed class CommonItem : Mapper<CommonUiModel> {

    class Success(
        val firstText: String,
        val secondText: String,
        val favorite: Boolean,
    ) : CommonItem() {
        override fun to(): CommonUiModel {
            return if (favorite) {
                FavoriteCommonUiModel(firstText, secondText)
            } else {
                BaseCommonUiModel(firstText, secondText)
            }
        }
    }

    class Failed(private val failure: Failure) : CommonItem() {
        override fun to(): CommonUiModel {
            return FailedCommonUiModel(failure.getMessage())
        }
    }

}