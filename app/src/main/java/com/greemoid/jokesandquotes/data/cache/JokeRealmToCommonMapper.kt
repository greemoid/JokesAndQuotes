package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.cache.RealmToCommonDataMapper
import com.greemoid.jokesandquotes.data.CommonDataModel

class JokeRealmToCommonMapper : RealmToCommonDataMapper<JokeRealmModel> {
    override fun map(realmObject: JokeRealmModel): CommonDataModel {
        return CommonDataModel(realmObject.id, realmObject.text, realmObject.punchline)
    }
}