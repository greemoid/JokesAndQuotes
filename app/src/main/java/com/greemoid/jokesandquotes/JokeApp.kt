package com.greemoid.jokesandquotes

import android.app.Application
import com.google.gson.Gson

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseJokeService(Gson()), BaseResourceManager(this)))
    }
}