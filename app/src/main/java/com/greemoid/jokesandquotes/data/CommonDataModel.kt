package com.greemoid.jokesandquotes.data

import com.greemoid.jokesandquotes.core.data.ChangeCommonItem
import com.greemoid.jokesandquotes.core.data.ChangeStatus
import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.domain.CommonItem

class CommonDataModel(
    private val id: Int,
    private val fistText: String,
    private val secondText: String,
    private val cached: Boolean = false,
) : ChangeCommonItem {

    fun <T> map(mapper: CommonDataModelMapper<T>): T {
        return mapper.map(id, fistText, secondText, cached)
    }

    override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
        return changeStatus.addOrRemove(id, this)
    }

    fun toJoke() = CommonItem.Success(fistText, secondText, cached)


    fun changeCached(cached: Boolean): CommonDataModel {
        return CommonDataModel(id, fistText, secondText, cached)
    }

}