package com.jmc.payment.data.remote

import com.jmc.payment.data.remote.models.NewPayment
import com.jmc.payment.data.remote.service.ApiService
import com.jmc.payment.data.repository.Remote
import javax.inject.Inject

internal class PaymentRemoteImpl @Inject constructor(private val apiService: ApiService) : Remote {

    override suspend fun getPaymentsMethods():  List<NewPayment> {
        return apiService.paymentMethods()
    }
}