package com.jmc.paymentapp.features.banks.data.remote

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.remote.service.BankApi
import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import retrofit2.Response
import javax.inject.Inject

class BankRemoteImpl @Inject constructor(private val apiService: BankApi) : BankRemote {
    
    override suspend fun getCardIssuers(id: String): List<CardIssuer> {
        return apiService.getCardIssuers(id)
    }
}