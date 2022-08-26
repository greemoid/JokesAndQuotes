package com.greemoid.jokesandquotes.core.data.cache

import com.greemoid.jokesandquotes.data.CommonDataModel
import io.realm.RealmObject

interface RealmToCommonDataMapper<T : RealmObject> {
    fun map(realmObject: T): CommonDataModel
}
