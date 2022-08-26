package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.cache.RealmProvider
import com.greemoid.jokesandquotes.data.mapper.JokeRealmMapper

class JokeCachedDataSource(
    realmProvider: RealmProvider,
    mapper: JokeRealmMapper,
    commonDataModelMapper: JokeRealmToCommonMapper,
) :
    BaseCachedDataSource<JokeRealmModel>(realmProvider, mapper, commonDataModelMapper) {
    override val dbClass: Class<JokeRealmModel> = JokeRealmModel::class.java
}