package com.jmc.paymentapp.features.payment.domain.repository

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import retrofit2.Response

interface PaymentRepository {

    suspend fun getPaymentsMethods(): Response<List<Payment>>
}