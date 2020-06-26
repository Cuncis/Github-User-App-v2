package com.cuncisboss.githubuserappv2.api

import com.cuncisboss.githubuserappv2.BuildConfig
import com.cuncisboss.githubuserappv2.model.DetailUserResponse
import com.cuncisboss.githubuserappv2.model.FollModel
import com.cuncisboss.githubuserappv2.model.SearchUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TheGithubApi {

    @GET("/search/users")
    fun searchUser(
        @Query("q") username: String
    ): Call<SearchUserResponse>

    @GET("/users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("/users/{username}/followers")
    @Headers("Authorization: ${BuildConfig.GITHUB_TOKEN}")
    fun getFollowers(
        @Path("username") username: String
    ): Call<List<FollModel>>

    @GET("/users/{username}/following")
    @Headers("Authorization: ${BuildConfig.GITHUB_TOKEN}")
    fun getFollowing(
        @Path("username") username: String
    ): Call<List<FollModel>>

}