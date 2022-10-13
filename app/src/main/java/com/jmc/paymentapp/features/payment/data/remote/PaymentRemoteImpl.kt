package com.jmc.paymentapp.features.payment.data.remote

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.payment.data.remote.service.PaymentApi
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import retrofit2.Response
import javax.inject.Inject

class PaymentRemoteImpl @Inject constructor(private val apiService: PaymentApi) : PaymentRemote {

    override suspend fun getPaymentsMethods(): Response<List<Payment>> {
        return apiService.paymentMethods()
    }
}