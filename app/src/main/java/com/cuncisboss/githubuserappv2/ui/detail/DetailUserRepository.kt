package com.cuncisboss.githubuserappv2.ui.detail

import androidx.lifecycle.MutableLiveData
import com.cuncisboss.githubuserappv2.api.ApiClient
import com.cuncisboss.githubuserappv2.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserRepository {

    val userData = MutableLiveData<DetailUserResponse>()
    val loading = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun getDetailUser(username: String): MutableLiveData<DetailUserResponse> {
        loading.value = true
        ApiClient.theGithubApi.getDetailUser(username)
            .enqueue(object : Callback<DetailUserResponse> {
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    loading.value = false
                    if (response.isSuccessful) {
                        userData.postValue(response.body())
                    } else {
                        message.value = response.message()
                    }
                }
                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    loading.value = false
                    message.value = t.message
                }
            })

        return userData
    }

}