package com.jmc.paymentapp.features.installments.data

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.source.InstallmentFactory
import com.jmc.paymentapp.features.installments.domain.repository.InstallmentRepository
import retrofit2.Response
import javax.inject.Inject

class InstallmentDataRepository @Inject constructor(
    private val factory: InstallmentFactory
) : InstallmentRepository {

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): List<InstallmentOption> {
        return factory.getRemote().getInstallmentsOptions(id, amount, issuerId)
    }

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float
    ): List<InstallmentOption> {
        return factory.getRemote().getInstallmentsOptions(id, amount)
    }


}