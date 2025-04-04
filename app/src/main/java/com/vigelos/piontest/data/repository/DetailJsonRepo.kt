package com.vigelos.piontest.data.repository

import com.vigelos.piontest.data.api.ApiService
import com.vigelos.piontest.data.model.DetailJson
import javax.inject.Inject

class DetailJsonRepo @Inject constructor(private val apiService: ApiService) {
    suspend fun getDetailJson(): DetailJson {
        return apiService.getDetailJson()
    }
}