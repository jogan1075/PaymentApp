package com.jmc.paymentapp.features.payment.data.remote.models

import com.google.gson.annotations.SerializedName

data class Bin (

    @SerializedName("pattern") val pattern : String,
    @SerializedName("installments_pattern") val installments_pattern : String,
    @SerializedName("exclusion_pattern") val exclusion_pattern : String
)