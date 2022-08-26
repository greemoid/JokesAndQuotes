package com.greemoid.jokesandquotes.data.net

import com.google.gson.annotations.SerializedName
import com.greemoid.jokesandquotes.core.Mapper
import com.greemoid.jokesandquotes.data.CommonDataModel

data class JokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val type: String,
    @SerializedName("setup")
    private val setup: String,
    @SerializedName("punchline")
    private val punchline: String,
) : Mapper<CommonDataModel> {
    override fun to(): CommonDataModel = CommonDataModel(id, setup, punchline)
}