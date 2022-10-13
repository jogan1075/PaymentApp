package com.jmc.paymentapp.features.payment.domain.model

data class PaymentModelUi(
    val id: String,
    val name: String,
    val status: String,
    val secureThumbnail: String,
    val thumbnail: String
)
