package com.jmc.payment.domain.repository

import com.jmc.payment.data.remote.models.NewPayment

internal interface Repository {

    suspend fun getPaymentsMethods(): List<NewPayment>
}