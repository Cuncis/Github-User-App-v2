package com.cuncisboss.githubuserappv2.ui.detail.foll

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuncisboss.githubuserappv2.model.FollModel

class FollViewModel : ViewModel() {

    private val repository = FollRepository()

    fun getFollowers(username: String): MutableLiveData<List<FollModel>> {
        return repository.getFollower(username)
    }

    fun getFollowing(username: String): MutableLiveData<List<FollModel>> {
        return repository.getFollowing(username)
    }

    fun onLoading(): MutableLiveData<Boolean> {
        return repository.loading
    }

    fun getMessage(): MutableLiveData<String> {
        return repository.message
    }

}