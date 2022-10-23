package com.jmc.payment.data.remote.models

import com.google.gson.annotations.SerializedName

data class SecurityCode (

    @SerializedName("length") val length : Int,
    @SerializedName("card_location") val card_location : String,
    @SerializedName("mode") val mode : String
)