package com.greemoid.jokesandquotes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.greemoid.jokesandquotes.JokeApp
import com.greemoid.jokesandquotes.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel
    private lateinit var quoteViewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as JokeApp).viewModel
        quoteViewModel = (application as JokeApp).quoteViewModel

        val jokeFavoriteDataView = findViewById<FavoriteDataView>(R.id.jokeFavoriteDataView)
        val quoteFavoriteDataView = findViewById<FavoriteDataView>(R.id.quoteFavoriteDataView)

        jokeFavoriteDataView.linkWith(viewModel)
        viewModel.observe(this) { state ->
            jokeFavoriteDataView.show(state)
        }

        quoteFavoriteDataView.linkWith(quoteViewModel)
        quoteViewModel.observe(this) { state ->
            quoteFavoriteDataView.show(state)
        }
    }
}