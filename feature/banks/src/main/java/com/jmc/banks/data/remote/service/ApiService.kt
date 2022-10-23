package com.jmc.banks.data.remote.service

import com.jmc.banks.data.remote.model.CardIssuer
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {

    @GET("payment_methods/card_issuers")
    suspend fun getCardIssuers(@Query("payment_method_id") payment_id: String): List<CardIssuer>
}