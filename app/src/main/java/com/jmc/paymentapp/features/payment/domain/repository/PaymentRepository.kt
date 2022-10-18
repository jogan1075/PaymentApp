package com.jmc.paymentapp.features.payment.domain.repository

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment

interface PaymentRepository {

    suspend fun getPaymentsMethods(): List<NewPayment>
}