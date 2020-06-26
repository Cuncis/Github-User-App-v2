package com.cuncisboss.githubuserappv2.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuncisboss.githubuserappv2.model.DetailUserResponse

class DetailUserViewModel : ViewModel() {

    private val repository = DetailUserRepository()

    fun getDetailUser(username: String) : MutableLiveData<DetailUserResponse> {
        return repository.getDetailUser(username)
    }

    fun onLoading(): MutableLiveData<Boolean> {
        return repository.loading
    }

    fun getMessage(): MutableLiveData<String> {
        return repository.message
    }

}