package com.jmc.paymentapp.features.payment.data

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import com.jmc.paymentapp.features.payment.data.source.PaymentSourceFactory
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import retrofit2.Response
import javax.inject.Inject

class PaymentDataRepository @Inject constructor(
    private val factory: PaymentSourceFactory
) : PaymentRepository {


    override suspend fun getPaymentsMethods(): Response<List<Payment>> {

        return factory.getRemote().getPaymentsMethods()
    }


}