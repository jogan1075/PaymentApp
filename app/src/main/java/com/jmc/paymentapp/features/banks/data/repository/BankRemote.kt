package com.jmc.paymentapp.features.banks.data.repository

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import retrofit2.Response

interface BankRemote {

    suspend fun getCardIssuers(id: String): List<CardIssuer>
}