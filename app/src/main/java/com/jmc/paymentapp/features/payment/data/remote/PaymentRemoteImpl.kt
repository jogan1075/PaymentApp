package com.jmc.paymentapp.features.payment.data.remote

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import com.jmc.paymentapp.features.payment.data.remote.service.PaymentApi
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import javax.inject.Inject

class PaymentRemoteImpl @Inject constructor(private val apiService: PaymentApi) : PaymentRemote {

    override suspend fun getPaymentsMethods():  List<NewPayment> {
        return apiService.paymentMethods()
    }
}