package com.jmc.installments.data

import com.jmc.installments.data.remote.model.InstallmentOption
import com.jmc.installments.data.source.SourceFactory
import com.jmc.installments.domain.repository.Repository
import javax.inject.Inject

internal class DataRepository @Inject constructor(
    private val factory: SourceFactory
) : Repository {

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