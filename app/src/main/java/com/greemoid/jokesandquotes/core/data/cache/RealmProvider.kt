package com.greemoid.jokesandquotes.core.data.cache

import io.realm.Realm

interface RealmProvider {
    fun provide(): Realm
}