package com.jmc.paymentapp.features.installments.domain.repository

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import retrofit2.Response

interface InstallmentRepository {

    suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): List<InstallmentOption>

    suspend fun getInstallmentsOptions(id: String, amount: Float): List<InstallmentOption>
}