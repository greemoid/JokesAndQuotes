package com.greemoid.jokesandquotes.data.net

import com.greemoid.jokesandquotes.core.Mapper
import com.greemoid.jokesandquotes.core.data.net.CloudDataSource
import com.greemoid.jokesandquotes.core.domain.NoConnectionException
import com.greemoid.jokesandquotes.core.domain.ServiceUnavailableException
import com.greemoid.jokesandquotes.data.CommonDataModel
import java.net.UnknownHostException

abstract class BaseCloudDataSource<T : Mapper<CommonDataModel>> : CloudDataSource {

    protected abstract suspend fun getServerModel(): T

    override suspend fun getData(): CommonDataModel {
        try {
            return getServerModel().to()
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }
}

