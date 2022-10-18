package com.jmc.paymentapp.features.installments.data.remote

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.remote.service.InstallmentsApi
import com.jmc.paymentapp.features.installments.data.repository.InstallmentRemote
import retrofit2.Response
import javax.inject.Inject

class InstallmentRemoteImpl @Inject constructor(private val apiService: InstallmentsApi) :
    InstallmentRemote {


    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): Response<List<InstallmentOption>> {
        return apiService.getInstallmentsOptions(id, amount, issuerId)
    }

    override suspend fun getInstallmentsOptions(
        id: String,
        amount: Float
    ): Response<List<InstallmentOption>> {
        return apiService.getInstallmentsOptions(id, amount)
    }
}