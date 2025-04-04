package com.vigelos.piontest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vigelos.piontest.data.model.DetailJson
import com.vigelos.piontest.data.repository.DetailJsonRepo
import com.vigelos.piontest.data.repository.NewFeedJsonRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailJsonRepo): ViewModel() {
    private val _detailJson = MutableLiveData<DetailJson>()
    val detailJson: LiveData<DetailJson> = _detailJson

    fun fetchDetailJson() {
        viewModelScope.launch {
            _detailJson.value = repository.getDetailJson()
        }
    }
}