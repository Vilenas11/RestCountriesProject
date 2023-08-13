package com.example.restcountriesproject.data_package

import com.google.gson.annotations.SerializedName

data class Flags (

    @SerializedName("png" ) var png : String? = null,
    @SerializedName("svg" ) var svg : String? = null,
    @SerializedName("alt" ) var alt : String? = null

)