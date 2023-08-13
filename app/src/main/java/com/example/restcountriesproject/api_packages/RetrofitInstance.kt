package com.example.restcountriesproject.api_packages

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}