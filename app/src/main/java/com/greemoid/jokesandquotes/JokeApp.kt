package com.greemoid.jokesandquotes

import android.app.Application
import com.greemoid.jokesandquotes.data.BaseRepository
import com.greemoid.jokesandquotes.data.CommonSuccessMapper
import com.greemoid.jokesandquotes.data.cache.*
import com.greemoid.jokesandquotes.data.mapper.JokeRealmMapper
import com.greemoid.jokesandquotes.data.mapper.QuoteRealmMapper
import com.greemoid.jokesandquotes.data.net.JokeCloudDataSource
import com.greemoid.jokesandquotes.data.net.JokeService
import com.greemoid.jokesandquotes.data.net.QuoteCloudDataSource
import com.greemoid.jokesandquotes.data.net.QuoteService
import com.greemoid.jokesandquotes.domain.BaseInteractor
import com.greemoid.jokesandquotes.domain.FailureFactory
import com.greemoid.jokesandquotes.presentation.BaseCommunication
import com.greemoid.jokesandquotes.presentation.BaseResourceManager
import com.greemoid.jokesandquotes.presentation.BaseViewModel
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp : Application() {

    lateinit var viewModel: BaseViewModel
    lateinit var quoteViewModel: BaseViewModel

    override fun onCreate() {
        super.onCreate()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        Realm.init(this)

        val resourceManager = BaseResourceManager(this)
        val cloudDataSource = JokeCloudDataSource(retrofit.create(JokeService::class.java))
        val jokeRepository =
            BaseRepository(
                JokeCachedDataSource(BaseRealmProvider(),
                    JokeRealmMapper(),
                    JokeRealmToCommonMapper()),
                cloudDataSource,
                BaseCachedData())
        val quoteRepository =
            BaseRepository(
                QuoteCachedDataSource(BaseRealmProvider(),
                    QuoteRealmMapper(),
                    QuoteRealmToCommonMapper()),
                QuoteCloudDataSource(retrofit.create(QuoteService::class.java)),
                BaseCachedData()
            )
        val failureHandler = FailureFactory(resourceManager)
        val interactor =
            BaseInteractor(jokeRepository, FailureFactory(resourceManager), CommonSuccessMapper())
        viewModel = BaseViewModel(interactor, BaseCommunication())
        quoteViewModel = BaseViewModel(
            BaseInteractor(quoteRepository, failureHandler, CommonSuccessMapper()),
            BaseCommunication()
        )
    }
}