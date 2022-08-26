package com.greemoid.jokesandquotes.data.net

import com.greemoid.jokesandquotes.data.NewJokeServerModel

class JokeCloudDataSource(private val service: JokeService) :
    BaseCloudDataSource<NewJokeServerModel>() {
    override suspend fun getServerModel(): NewJokeServerModel {
        return service.getJoke()
    }
}
