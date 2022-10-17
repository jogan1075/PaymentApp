package com.jmc.paymentapp.features.installments.data.repository

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import retrofit2.Response

interface InstallmentRemote {
    suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): Response<List<InstallmentOption>>

    suspend fun getInstallmentsOptions(id: String, amount: Float): Response<List<InstallmentOption>>
}