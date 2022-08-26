package com.greemoid.jokesandquotes.data.mapper

import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.data.cache.QuoteRealmModel

class QuoteRealmMapper : CommonDataModelMapper<QuoteRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): QuoteRealmModel =
        QuoteRealmModel().also { quote ->
            quote.id = id
            quote.content = first
            quote.author = second
        }
}