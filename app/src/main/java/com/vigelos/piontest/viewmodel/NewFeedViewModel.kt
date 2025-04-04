package com.vigelos.piontest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vigelos.piontest.data.model.NewFeedJson
import com.vigelos.piontest.data.repository.NewFeedJsonRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewFeedViewModel @Inject constructor(private val repository: NewFeedJsonRepo) : ViewModel() {
    private val _newFeedJson = MutableLiveData<NewFeedJson>()
    val newFeedJson: LiveData<NewFeedJson> = _newFeedJson

    fun fetchNewFeedJson() {
        viewModelScope.launch {
            _newFeedJson.value = repository.getNewFeedJson()
        }
    }
}