package com.jmc.banks.data

import com.jmc.banks.data.remote.model.CardIssuer
import com.jmc.banks.data.source.SourceFactory
import com.jmc.banks.domain.repository.Repository
import javax.inject.Inject

internal class DataRepository @Inject constructor(
    private val factory: SourceFactory
) : Repository {

    override suspend fun getCardIssuers(id: String): List<CardIssuer> {
        return factory.getRemote().getCardIssuers(id)
    }

}