package com.example.restcountriesproject.Repositories

import com.example.restcountriesproject.API_Package.RetrofitInstance
import com.example.restcountriesproject.data_package.Country

class Repository {
    suspend fun getCountry(): List<Country> {
        return RetrofitInstance.api.getCountries()
    }
}