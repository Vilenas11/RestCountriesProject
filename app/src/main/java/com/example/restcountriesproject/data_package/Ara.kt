package com.example.restcountriesproject.data_package

import com.google.gson.annotations.SerializedName

data class Ara(
    @SerializedName("official" ) var official : String? = null,
    @SerializedName("common"   ) var common   : String? = null
)