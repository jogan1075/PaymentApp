package com.jmc.paymentapp.features.payment.data.repository

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment

interface PaymentRemote {

    suspend fun getPaymentsMethods():  List<NewPayment>
}