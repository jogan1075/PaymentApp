package com.jmc.paymentapp.features.payment.domain

import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import javax.inject.Inject

class GetPaymentsMethodsUseCase @Inject constructor(
    private val repository: PaymentRepository
) {

    suspend fun execute() = repository.getPaymentsMethods()
}