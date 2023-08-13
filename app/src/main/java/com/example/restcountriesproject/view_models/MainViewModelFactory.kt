package com.example.restcountriesproject.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restcountriesproject.repositories.Repository

class MainViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return MainViewModel(repository) as T
    }
}