package com.jmc.paymentapp.features.banks.data.repository

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import retrofit2.Response

interface BankRemote {

    suspend fun getCardIssuers(id: String): Response<List<CardIssuer>>
}