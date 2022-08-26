package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.cache.RealmProvider
import com.greemoid.jokesandquotes.data.mapper.QuoteRealmMapper

class QuoteCachedDataSource(
    realmProvider: RealmProvider,
    mapper: QuoteRealmMapper,
    commonDataModelMapper: QuoteRealmToCommonMapper,
) : BaseCachedDataSource<QuoteRealmModel>(realmProvider, mapper, commonDataModelMapper) {
    override val dbClass: Class<QuoteRealmModel> = QuoteRealmModel::class.java

}