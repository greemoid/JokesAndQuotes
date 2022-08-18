package com.greemoid.jokesandquotes

import io.realm.Realm

interface CloudDataSource {

    fun getJoke(callback: JokeCloudCallback)

}