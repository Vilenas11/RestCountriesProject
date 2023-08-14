package com.example.restcountriesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesproject.adapters.RecyclerViewAdapter
import com.example.restcountriesproject.data_package.Country
import com.example.restcountriesproject.repositories.Repository
import com.example.restcountriesproject.view_models.MainViewModel
import com.example.restcountriesproject.view_models.MainViewModelFactory
import java.util.Locale

class SecondActivity : AppCompatActivity(){
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        buildRecyclerView()
//        var myRecycler : RecyclerView = findViewById(R.id.countryRecyclerView)
//        var adapter : RecyclerViewAdapter = RecyclerViewAdapter(viewModel.myResponse)
//        myRecycler.adapter = adapter
//        myRecycler.layoutManager = LinearLayoutManager(this)


    }

    private fun buildRecyclerView() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCountry()
        viewModel.myResponse.value
        viewModel.myResponse.observe(this, Observer { response ->

            if(response.isSuccessful){
                var myRecycler: RecyclerView = findViewById(R.id.countryRecyclerView)
                var adapter: RecyclerViewAdapter = RecyclerViewAdapter(response.body()!!)
                myRecycler.adapter = adapter
                myRecycler.layoutManager = LinearLayoutManager(this)

                var searchView: SearchView = findViewById(R.id.searchViewId)
                searchView.clearFocus()

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        searchView.clearFocus()

                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        filterList(newText, response.body()!!, adapter)
                        return true
                    }

                })
            }
            else {
                Log.i("Errors", response.errorBody().toString())
                Toast.makeText(this,"ERROR GETTING DATA FROM API: ${response.errorBody().toString()}", Toast.LENGTH_LONG).show()

            }
        })

    }


    fun filterList(query: String?, response: List<Country>, adapter : RecyclerViewAdapter) {
        if (query != null) {
            val filteredList = ArrayList<Country>()
            for (i in response) {
                if(i.name.toString().toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){
                Toast.makeText(this,"No Data Found", Toast.LENGTH_SHORT).show()
            }
            else{
                adapter.setFilteredList(filteredList)
            }
        }
    }
}