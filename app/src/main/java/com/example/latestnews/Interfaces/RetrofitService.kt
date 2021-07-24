package com.example.latestnews.Interfaces

import com.example.latestnews.Models.Article
import retrofit2.http.GET
import retrofit2.Call


interface RetrofitService {
    @GET("articlesByCategory?id=13")
    fun getArticlesList() : Call<MutableList<Article>>
}