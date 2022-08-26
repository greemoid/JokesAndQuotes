package com.greemoid.jokesandquotes.data.net

class QuoteCloudDataSource(
    private val service: QuoteService,
) : BaseCloudDataSource<QuoteServerModel>() {
    override suspend fun getServerModel(): QuoteServerModel {
        return service.getQuote()
    }
}