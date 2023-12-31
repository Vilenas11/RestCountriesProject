package com.example.restcountriesproject.data_package

import com.google.gson.annotations.SerializedName

data class Name (
    @SerializedName("common"     ) var common     : String?     = null,
    @SerializedName("official"   ) var official   : String?     = null,
    @SerializedName("nativeName" ) var nativeName : NativeName? = NativeName()
)