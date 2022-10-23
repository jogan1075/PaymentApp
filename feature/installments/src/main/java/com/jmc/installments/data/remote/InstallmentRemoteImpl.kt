package com.jmc.installments.data.remote

import com.jmc.installments.data.remote.model.InstallmentOption
import com.jmc.installments.data.remote.service.ApiService
import com.jmc.installments.data.repository.Remote
import javax.inject.Inject

internal class InstallmentRemoteImpl @Inject constructor(private val apiService: ApiService) :
    Remote {


    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): List<InstallmentOption> {
        return apiService.getInstallmentsOptions(id, amount, issuerId)
    }

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float
    ): List<InstallmentOption> {
        return apiService.getInstallmentsOptions(id, amount)
    }
}