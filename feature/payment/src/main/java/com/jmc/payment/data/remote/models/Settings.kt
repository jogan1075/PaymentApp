package com.jmc.payment.data.remote.models

import com.google.gson.annotations.SerializedName


data class Settings (

    @SerializedName("card_number") val card_number : CardNumber,
    @SerializedName("bin") val bin : Bin,
    @SerializedName("security_code") val security_code : SecurityCode
)