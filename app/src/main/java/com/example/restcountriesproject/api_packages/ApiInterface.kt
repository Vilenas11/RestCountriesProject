package com.example.restcountriesproject.api_packages

import com.example.restcountriesproject.data_package.Country
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("all?fields=capital,name,flags,area")
    suspend fun getCountries(): Response<List<Country>>
}