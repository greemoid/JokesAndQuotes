package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.Mapper
import com.greemoid.jokesandquotes.data.CommonDataModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class QuoteRealmModel : RealmObject(), Mapper<CommonDataModel> {

    @PrimaryKey
    var id: Int = -1
    var content: String = ""
    var author: String = ""

    override fun to(): CommonDataModel = CommonDataModel(id, content, author, true)
}