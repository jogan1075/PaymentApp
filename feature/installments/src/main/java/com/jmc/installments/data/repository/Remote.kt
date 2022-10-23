package com.jmc.installments.data.repository

import com.jmc.installments.data.remote.model.InstallmentOption

internal interface Remote {
    suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): List<InstallmentOption>

    suspend fun getInstallmentsOptions(id: String, amount: Float): List<InstallmentOption>
}