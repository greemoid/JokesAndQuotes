package com.greemoid.jokesandquotes

import com.google.gson.Gson
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.net.UnknownHostException
import javax.net.ssl.HttpsURLConnection

class BaseJokeService(private val gson: Gson) : JokeService {
    override fun getJoke(callBack: ServiceCallback) {
        Thread {
            var connection: HttpsURLConnection? = null
            try {
                val url = URL(JOKE_URL)
                connection = url.openConnection() as HttpsURLConnection
                InputStreamReader(BufferedInputStream(connection.inputStream)).use {
                    val line: String = it.readText()
                    val dto = gson.fromJson(line, JokeDTO::class.java)
                    callBack.returnSuccess(dto)
                }
            } catch (e: Exception) {
                if (e is UnknownHostException)
                    callBack.returnError(ErrorType.NO_CONNECTION)
                else
                    callBack.returnError(ErrorType.OTHER)
            } finally {
                connection?.disconnect()
            }
        }.start()
    }

    companion object {
        const val JOKE_URL = "https://nova-joke-api.netlify.app/.netlify/functions/index/api/random"
    }

}