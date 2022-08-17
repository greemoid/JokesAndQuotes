package com.greemoid.jokesandquotes


interface JokeService {


    fun getJoke(callBack: ServiceCallback)

}

interface ServiceCallback {

    fun returnSuccess(data: JokeDTO)

    fun returnError(type: ErrorType)

}

enum class ErrorType {
    NO_CONNECTION,
    OTHER
}