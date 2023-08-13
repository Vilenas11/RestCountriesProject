package com.example.restcountriesproject.data_package

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("flags"   ) var flags   : Flags?            = Flags(),
    @SerializedName("name"    ) var name    : Name?             = Name(),
    @SerializedName("capital" ) var capital : ArrayList<String> = arrayListOf(),
    @SerializedName("area"    ) var area    : Float?              = null

)