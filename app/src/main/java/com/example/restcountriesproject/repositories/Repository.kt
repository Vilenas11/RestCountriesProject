package com.example.restcountriesproject.repositories

import com.example.restcountriesproject.api_packages.RetrofitInstance
import com.example.restcountriesproject.data_package.Country

class Repository {
    suspend fun getCountry(): List<Country> {
        return RetrofitInstance.api.getCountries()
    }
}