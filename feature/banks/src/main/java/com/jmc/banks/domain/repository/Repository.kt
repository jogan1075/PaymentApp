package com.jmc.banks.domain.repository

import com.jmc.banks.data.remote.model.CardIssuer

internal interface Repository {

    suspend fun getCardIssuers(id: String): List<CardIssuer>
}