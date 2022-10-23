package com.jmc.payment.domain

import com.jmc.payment.domain.repository.Repository
import javax.inject.Inject

internal class GetPaymentsMethodsUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute() = repository.getPaymentsMethods()
}