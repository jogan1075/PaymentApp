package com.jmc.paymentapp.features.installments.data

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.source.InstallmentFactory
import com.jmc.paymentapp.features.installments.domain.repository.InstallmentRepository
import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import com.jmc.paymentapp.features.payment.data.source.PaymentSourceFactory
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import retrofit2.Response
import javax.inject.Inject

class InstallmentDataRepository @Inject constructor(
    private val factory: InstallmentFactory
) : InstallmentRepository {

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): Response<List<InstallmentOption>> {
        return factory.getRemote().getInstallmentsOptions(id, amount, issuerId)
    }

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float
    ): Response<List<InstallmentOption>> {
        return factory.getRemote().getInstallmentsOptions(id, amount)
    }


}