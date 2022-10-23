package com.jmc.banks.domain

import com.jmc.banks.domain.repository.Repository
import javax.inject.Inject

internal class GetCardIssuersUseCase @Inject constructor(
    private val repository: Repository,
) {

    suspend fun execute(id: String) = repository.getCardIssuers(id = id)


}