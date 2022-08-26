package com.greemoid.jokesandquotes.data

import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.domain.CommonItem

class CommonSuccessMapper : CommonDataModelMapper<CommonItem.Success> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): CommonItem.Success =
        CommonItem.Success(first, second, cached)
}