package com.greemoid.jokesandquotes

import android.content.Context
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringRes: Int): String
}

class BaseResourceManager(private val context: Context): ResourceManager {
    override fun getString(stringRes: Int): String {
        return context.getString(stringRes)
    }

}