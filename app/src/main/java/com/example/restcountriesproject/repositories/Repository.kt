package com.example.restcountriesproject.repositories

import com.example.restcountriesproject.api_packages.RetrofitInstance
import com.example.restcountriesproject.data_package.Country
import retrofit2.Response

class Repository {
    suspend fun getCountry(): Response<List<Country>> {
        return RetrofitInstance.api.getCountries()
    }
}