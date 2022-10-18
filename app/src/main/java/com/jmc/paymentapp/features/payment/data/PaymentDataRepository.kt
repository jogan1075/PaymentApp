package com.jmc.paymentapp.features.payment.data

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import com.jmc.paymentapp.features.payment.data.source.PaymentSourceFactory
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import javax.inject.Inject

class PaymentDataRepository @Inject constructor(
    private val factory: PaymentSourceFactory
) : PaymentRepository {


    override suspend fun getPaymentsMethods(): List<NewPayment> {

        return factory.getRemote().getPaymentsMethods()
    }


}