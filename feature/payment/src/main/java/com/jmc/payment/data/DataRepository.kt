package com.jmc.payment.data

import com.jmc.payment.data.remote.models.NewPayment
import com.jmc.payment.data.source.SourceFactory
import com.jmc.payment.domain.repository.Repository
import javax.inject.Inject

internal class DataRepository @Inject constructor(
    private val factory: SourceFactory
) : Repository {


    override suspend fun getPaymentsMethods(): List<NewPayment> {

        return factory.getRemote().getPaymentsMethods()
    }


}