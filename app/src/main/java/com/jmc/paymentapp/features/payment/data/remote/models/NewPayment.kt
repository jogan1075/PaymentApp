package com.jmc.paymentapp.features.payment.data.remote.models

import com.google.gson.annotations.SerializedName



data class NewPayment (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("payment_type_id") val payment_type_id : String,
    @SerializedName("status") val status : String,
    @SerializedName("secure_thumbnail") val secure_thumbnail : String,
    @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("deferred_capture") val deferred_capture : String,
    @SerializedName("settings") val settings : List<Settings>,
    @SerializedName("additional_info_needed") val additional_info_needed : List<String>,
    @SerializedName("min_allowed_amount") val min_allowed_amount : Int,
    @SerializedName("max_allowed_amount") val max_allowed_amount : Int,
    @SerializedName("accreditation_time") val accreditation_time : Int,
    @SerializedName("financial_institutions") val financial_institutions : List<String>,
    @SerializedName("processing_modes") val processing_modes : List<String>
)