/*
package com.greemoid.jokesandquotes

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException

class TestModel(
    private val baseJokeService: JokeService,
    resourceManager: ResourceManager,
) : Model {

    private var callback: JokeCallback? = null
    private var count = 0
    private val noConnection = NoConnection(resourceManager)
    private val serviceUnavailable = ServiceUnavailable(resourceManager)

    override fun getJoke() {
        baseJokeService.getJoke().enqueue(object : Callback<JokeServerModel> {
            override fun onResponse(call: Call<JokeServerModel>, response: Response<JokeServerModel>) {
                if (response.isSuccessful) {
                    callback?.provideSuccess(response.body()!!.toJoke())
                } else {
                    callback?.provideError(serviceUnavailable)
                }
            }

            override fun onFailure(call: Call<JokeServerModel>, t: Throwable) {
                if (t is UnknownHostException) {
                    callback?.provideError(noConnection)
                } else {
                    callback?.provideError(serviceUnavailable)
                }
            }

        })
    }

    override fun init(callback: JokeCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }


}*/
