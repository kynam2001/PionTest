package com.vigelos.piontest.data.api

import com.vigelos.piontest.data.model.NewFeedJson
import retrofit2.http.GET

interface ApiService {
    @GET("newsfeed.json")
    suspend fun getNewFeedJson(): NewFeedJson
}