package com.example.latestnews.Common

import com.example.latestnews.Interfaces.RetrofitService
import com.example.latestnews.Retrofit.RetrofitClient

object Common {
    private val BaseUrl = "https://mobilapp.kozbeszerzes.hu/api/content/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BaseUrl).create(RetrofitService::class.java)
}