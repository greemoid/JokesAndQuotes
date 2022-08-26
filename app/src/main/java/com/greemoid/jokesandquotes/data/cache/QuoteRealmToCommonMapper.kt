package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.cache.RealmToCommonDataMapper
import com.greemoid.jokesandquotes.data.CommonDataModel

class QuoteRealmToCommonMapper : RealmToCommonDataMapper<QuoteRealmModel> {
    override fun map(realmObject: QuoteRealmModel): CommonDataModel {
        return CommonDataModel(realmObject.id, realmObject.content, realmObject.author)
    }

}