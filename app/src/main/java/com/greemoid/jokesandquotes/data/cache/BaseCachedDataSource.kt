package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.CommonDataModelMapper
import com.greemoid.jokesandquotes.core.data.cache.CacheDataSource
import com.greemoid.jokesandquotes.core.data.cache.RealmProvider
import com.greemoid.jokesandquotes.core.data.cache.RealmToCommonDataMapper
import com.greemoid.jokesandquotes.core.domain.NoCachedDataException
import com.greemoid.jokesandquotes.data.CommonDataModel
import io.realm.RealmObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseCachedDataSource<T : RealmObject>(
    private val realmProvider: RealmProvider,
    private val mapper: CommonDataModelMapper<T>,
    private val realmToCommonDataMapper: RealmToCommonDataMapper<T>,
) : CacheDataSource {

    protected abstract val dbClass: Class<T>

    override suspend fun getData(): CommonDataModel {
        realmProvider.provide().use {
            val list = it.where(dbClass).findAll()
            if (list.isEmpty())
                throw NoCachedDataException()
            else
                return realmToCommonDataMapper.map(list.random())
        }
    }

    override suspend fun addOrRemove(id: Int, model: CommonDataModel): CommonDataModel =
        withContext(Dispatchers.IO) {
            realmProvider.provide().use {
                val itemRealm =
                    it.where(dbClass).equalTo("id", id).findFirst()
                return@withContext if (itemRealm == null) {
                    it.executeTransaction { transition ->
                        val newData = model.map(mapper)
                        transition.insert(newData)
                    }
                    model.changeCached(true)
                } else {
                    it.executeTransaction {
                        itemRealm.deleteFromRealm()
                    }
                    model.changeCached(false)
                }
            }
        }
}


