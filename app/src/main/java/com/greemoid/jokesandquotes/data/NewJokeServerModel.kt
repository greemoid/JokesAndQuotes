package com.greemoid.jokesandquotes.data

import com.google.gson.annotations.SerializedName
import com.greemoid.jokesandquotes.core.Mapper

class NewJokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("delivery")
    private val punchline: String,
) : Mapper<CommonDataModel> {
    override fun to(): CommonDataModel = CommonDataModel(id, text, punchline)
}