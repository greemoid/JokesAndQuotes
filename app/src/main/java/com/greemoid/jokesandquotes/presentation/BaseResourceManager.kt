package com.greemoid.jokesandquotes.presentation

import android.content.Context
import com.greemoid.jokesandquotes.core.ResourceManager

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringRes: Int): String {
        return context.getString(stringRes)
    }
}