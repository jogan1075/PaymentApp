package com.jmc.paymentapp.features.banks.domain

import com.jmc.paymentapp.features.banks.domain.repository.BankRepository
import javax.inject.Inject

class GetCardIssuersUseCase @Inject constructor(
    private val repository: BankRepository,
) {

    suspend fun execute(id: String) = repository.getCardIssuers(id = id)


}