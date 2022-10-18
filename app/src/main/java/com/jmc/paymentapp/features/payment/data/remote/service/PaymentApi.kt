package com.jmc.paymentapp.features.payment.data.remote.service

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import retrofit2.http.GET

interface PaymentApi {

    @GET("payment_methods")
    suspend fun paymentMethods(): List<NewPayment>

}