package com.vigelos.piontest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vigelos.piontest.data.model.NewFeedJson
import com.vigelos.piontest.data.repository.NewFeedJsonRepo
import kotlinx.coroutines.launch

class NewFeedViewModel: ViewModel() {
    private val repository = NewFeedJsonRepo()
    private val _newFeedJson = MutableLiveData<NewFeedJson>()
    val newFeedJson: LiveData<NewFeedJson> = _newFeedJson

    fun fetchNewFeedJson() {
        viewModelScope.launch {
            val response = repository.getNewFeedJson()
            _newFeedJson.value = response
        }
    }
}