package com.greemoid.jokesandquotes.data.cache

import com.greemoid.jokesandquotes.core.data.cache.RealmProvider
import io.realm.Realm


class BaseRealmProvider : RealmProvider {
    override fun provide(): Realm = Realm.getDefaultInstance()


}