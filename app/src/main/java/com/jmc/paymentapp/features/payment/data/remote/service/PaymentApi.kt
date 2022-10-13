package com.jmc.paymentapp.features.payment.data.remote.service

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import retrofit2.Response
import retrofit2.http.GET

interface PaymentApi {

    @GET("payment_methods")
    suspend fun paymentMethods(): Response<List<Payment>>

}