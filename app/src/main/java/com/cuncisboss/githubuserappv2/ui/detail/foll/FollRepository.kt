package com.cuncisboss.githubuserappv2.ui.detail.foll

import androidx.lifecycle.MutableLiveData
import com.cuncisboss.githubuserappv2.api.ApiClient
import com.cuncisboss.githubuserappv2.model.FollModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollRepository {

    val followerList = MutableLiveData<List<FollModel>>()
    val followingList = MutableLiveData<List<FollModel>>()
    val loading = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun getFollower(username: String): MutableLiveData<List<FollModel>> {
        loading.value = true
        ApiClient.theGithubApi.getFollowers(username)
            .enqueue(object : Callback<List<FollModel>> {
                override fun onResponse(
                    call: Call<List<FollModel>>,
                    response: Response<List<FollModel>>
                ) {
                    loading.value = false
                    if (response.isSuccessful) {
                        followerList.postValue(response.body())
                    } else {
                        message.value = response.message()
                    }
                }

                override fun onFailure(call: Call<List<FollModel>>, t: Throwable) {
                    loading.value = false
                    message.value = t.message
                }
            })

        return followerList
    }

    fun getFollowing(username: String): MutableLiveData<List<FollModel>> {
        loading.value = true
        ApiClient.theGithubApi.getFollowing(username)
            .enqueue(object : Callback<List<FollModel>> {
                override fun onResponse(
                    call: Call<List<FollModel>>,
                    response: Response<List<FollModel>>
                ) {
                    loading.value = false
                    if (response.isSuccessful) {
                        followingList.postValue(response.body())
                    } else {
                        message.value = response.message()
                    }
                }

                override fun onFailure(call: Call<List<FollModel>>, t: Throwable) {
                    loading.value = false
                    message.value = t.message
                }
            })

        return followingList
    }

}