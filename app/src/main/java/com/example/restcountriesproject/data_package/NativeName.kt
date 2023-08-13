package com.example.restcountriesproject.data_package

import com.google.gson.annotations.SerializedName

data class NativeName(
    @SerializedName("ara" ) var ara : Ara? = Ara()
)