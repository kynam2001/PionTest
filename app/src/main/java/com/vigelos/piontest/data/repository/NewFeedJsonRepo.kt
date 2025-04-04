package com.vigelos.piontest.data.repository

import com.vigelos.piontest.data.api.ApiService
import com.vigelos.piontest.data.model.NewFeedJson
import javax.inject.Inject

class NewFeedJsonRepo @Inject constructor(private val apiService: ApiService) {
    suspend fun getNewFeedJson(): NewFeedJson{
        return apiService.getNewFeedJson()
    }
}