package com.jmc.paymentapp.features.banks.domain.repository

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import retrofit2.Response

interface BankRepository {

    suspend fun getCardIssuers(id: String): List<CardIssuer>
}