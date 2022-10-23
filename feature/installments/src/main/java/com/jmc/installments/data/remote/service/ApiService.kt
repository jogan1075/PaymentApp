package com.jmc.installments.data.remote.service

import com.jmc.installments.data.remote.model.InstallmentOption
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {

    @GET("payment_methods/installments")
    suspend fun getInstallmentsOptions(
        @Query("payment_method_id") payment_id: String,
        @Query("amount") amount: Float,
        @Query("issuer.id") issuer_id: String
    ):List<InstallmentOption>

    @GET("payment_methods/installments")
    suspend fun getInstallmentsOptions(
        @Query("payment_method_id") payment_id: String,
        @Query("amount") amount: Float,
    ): List<InstallmentOption>
}