package com.jmc.paymentapp.features.payment.data.repository

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import retrofit2.Response

interface PaymentRemote {

    suspend fun getPaymentsMethods(): Response<List<Payment>>
}