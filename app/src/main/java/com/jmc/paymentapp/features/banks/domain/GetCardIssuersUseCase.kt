package com.jmc.paymentapp.features.banks.domain

import com.jmc.paymentapp.features.banks.domain.mapper.BankMapper
import com.jmc.paymentapp.features.banks.domain.repository.BankRepository
import javax.inject.Inject

class GetCardIssuersUseCase @Inject constructor(
    private val repository: BankRepository,
    private val mapper: BankMapper
) {

    suspend fun execute(id: String) = repository.getCardIssuers(id = id).body()?.map(mapper::map)


}