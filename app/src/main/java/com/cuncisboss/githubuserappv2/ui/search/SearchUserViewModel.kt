package com.cuncisboss.githubuserappv2.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuncisboss.githubuserappv2.model.SearchUserResponse
import com.cuncisboss.githubuserappv2.ui.search.SearchUserRepository

class SearchUserViewModel : ViewModel() {
    private val repository =
        SearchUserRepository()

    fun searchUser(username: String): MutableLiveData<SearchUserResponse> {
        return repository.searchUser(username)
    }

    fun onLoading(): MutableLiveData<Boolean> {
        return repository.loading
    }

    fun getMessage(): MutableLiveData<String> {
        return repository.message
    }

}