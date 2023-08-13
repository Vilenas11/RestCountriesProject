package com.example.restcountriesproject.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountriesproject.data_package.Country
import com.example.restcountriesproject.repositories.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<List<Country>> = MutableLiveData()
    fun getCountry(){
        viewModelScope.launch{
            var response = repository.getCountry()
            response = response.sortedBy { it.name!!.common } //sort alphabetically
            myResponse.value = response
        }
    }
}