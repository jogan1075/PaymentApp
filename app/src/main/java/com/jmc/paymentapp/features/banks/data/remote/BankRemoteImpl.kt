package com.jmc.paymentapp.features.banks.data.remote

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.remote.service.BankApi
import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.payment.data.remote.service.PaymentApi
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import retrofit2.Response
import javax.inject.Inject

class BankRemoteImpl @Inject constructor(private val apiService: BankApi) : BankRemote {
    
    override suspend fun getCardIssuers(id: String): Response<List<CardIssuer>> {
        return apiService.getCardIssuers(id)
    }
}