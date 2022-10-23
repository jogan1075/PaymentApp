package com.jmc.installments.domain.repository

import com.jmc.installments.data.remote.model.InstallmentOption

internal interface Repository {

    suspend fun getInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String
    ): List<InstallmentOption>

    suspend fun getInstallmentsOptions(id: String, amount: Float): List<InstallmentOption>
}