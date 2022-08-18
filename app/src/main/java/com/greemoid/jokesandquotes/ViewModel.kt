package com.greemoid.jokesandquotes

class ViewModel(private val model: Model) {

    private var callback: DataCallback? = null

    private val jokeCallback = object : JokeCallback {
        override fun provide(joke: JokeUiModel) {
            callback?.let {
                joke.map(it)
            }
        }

    }

    fun init(callback: DataCallback) {
        this.callback = callback
        model.init(jokeCallback)
    }

    fun chooseFavorites(favorites: Boolean) {
        model.chooseDataSource(favorites)
    }

    fun changeJokeStatus() {
        model.changeJokeStatus(jokeCallback)
    }

    fun getJoke()  {
        model.getJoke()
    }


    fun clear() {
        callback = null
        model.clear()
    }
}