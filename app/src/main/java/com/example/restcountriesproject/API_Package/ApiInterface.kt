package com.example.restcountriesproject.API_Package

import com.example.restcountriesproject.data_package.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("all?fields=capital,name,flags,area")
    suspend fun getCountries(): List<Country>
}