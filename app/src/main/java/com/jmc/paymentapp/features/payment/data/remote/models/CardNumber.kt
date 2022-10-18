package com.jmc.paymentapp.features.payment.data.remote.models

import com.google.gson.annotations.SerializedName

data class CardNumber (

    @SerializedName("validation") val validation : String,
    @SerializedName("length") val length : Int
)