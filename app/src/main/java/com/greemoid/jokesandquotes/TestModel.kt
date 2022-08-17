package com.greemoid.jokesandquotes

class TestModel(
    private val baseJokeService: BaseJokeService,
    resourceManager: ResourceManager,
) : Model {

    private var callback: ResultCallback? = null
    private var count = 0
    private val noConnection = NoConnection(resourceManager)
    private val serviceUnavailable = ServiceUnavailable(resourceManager)

    override fun getJoke() {
        baseJokeService.getJoke(object : ServiceCallback {
            override fun returnSuccess(data: JokeDTO) {
                callback?.provideSuccess(data.toJoke())
            }

            override fun returnError(type: ErrorType) {
                when(type) {
                    ErrorType.NO_CONNECTION -> callback?.provideError(noConnection)
                    ErrorType.OTHER -> callback?.provideError(serviceUnavailable)
                }
            }

        })
    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }


}