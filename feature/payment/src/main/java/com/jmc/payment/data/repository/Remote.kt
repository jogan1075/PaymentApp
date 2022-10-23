package com.jmc.payment.data.repository

import com.jmc.payment.data.remote.models.NewPayment

internal interface Remote {

    suspend fun getPaymentsMethods():  List<NewPayment>
}