package com.greemoid.jokesandquotes.data.net

import com.google.gson.annotations.SerializedName
import com.greemoid.jokesandquotes.core.Mapper
import com.greemoid.jokesandquotes.data.CommonDataModel

class QuoteServerModel(
    @SerializedName("_id")
    private val id: Int,
    @SerializedName("content")
    private val content: String,
    @SerializedName("author")
    private val author: String,
) : Mapper<CommonDataModel> {
    override fun to(): CommonDataModel =
        CommonDataModel(System.currentTimeMillis().toInt(), content, author)

}