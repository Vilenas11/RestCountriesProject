package com.example.restcountriesproject.API_Package

import com.example.restcountriesproject.data.CountryData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("all")
    fun getData() : Call<List<CountryData>>
}