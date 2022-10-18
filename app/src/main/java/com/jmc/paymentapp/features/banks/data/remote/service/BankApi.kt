package com.jmc.paymentapp.features.banks.data.remote.service

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BankApi {

    @GET("payment_methods/card_issuers")
    suspend fun getCardIssuers(@Query("payment_method_id") payment_id: String): List<CardIssuer>
}