package com.submission.yugioh.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.submission.yugioh.api.RetrofitInstance
import com.submission.yugioh.model.DataResponse
import com.submission.yugioh.utils.Resource

class Repository {

    fun getData(): LiveData<Resource<DataResponse>> = liveData {
        val data = MutableLiveData<Resource<DataResponse>>()
        emit(Resource.Loading)
        try {
            val response = RetrofitInstance.api.getData(20,0,"id")
            data.value = Resource.Success(response)
        } catch (e: Exception) {
            data.value = Resource.Error(e.message.toString())
        }
        emitSource(data)
    }
}