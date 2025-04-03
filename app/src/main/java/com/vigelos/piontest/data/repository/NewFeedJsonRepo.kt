package com.vigelos.piontest.data.repository

import com.vigelos.piontest.data.api.RetrofitInstance
import com.vigelos.piontest.data.model.NewFeedJson

class NewFeedJsonRepo {
    suspend fun getNewFeedJson(): NewFeedJson{
        return RetrofitInstance.api.getNewFeedJson()
    }
}