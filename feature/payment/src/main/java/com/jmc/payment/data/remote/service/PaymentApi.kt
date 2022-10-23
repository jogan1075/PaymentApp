package com.jmc.payment.data.remote.service

import com.jmc.payment.data.remote.models.NewPayment
import retrofit2.http.GET

internal interface ApiService {

    @GET("payment_methods")
    suspend fun paymentMethods(): List<NewPayment>

}