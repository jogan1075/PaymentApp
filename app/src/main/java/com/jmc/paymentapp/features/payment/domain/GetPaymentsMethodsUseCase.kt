package com.jmc.paymentapp.features.payment.domain

import com.jmc.paymentapp.features.payment.domain.mapper.PaymentMapper
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import javax.inject.Inject

class GetPaymentsMethodsUseCase @Inject constructor(
    private val repository: PaymentRepository,
    private val mapper: PaymentMapper
) {

    suspend fun execute() = repository.getPaymentsMethods().body()?.map(mapper::map)
}