package com.jmc.paymentapp.features.banks.data

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.source.BankSourceFactory
import com.jmc.paymentapp.features.banks.domain.repository.BankRepository
import retrofit2.Response
import javax.inject.Inject

class BankDataRepository @Inject constructor(
    private val factory: BankSourceFactory
) : BankRepository {

    override suspend fun getCardIssuers(id: String): Response<List<CardIssuer>> {
        return factory.getRemote().getCardIssuers(id)
    }

}