package com.example.restcountriesproject.API_Package

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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