package com.jmc.banks.data.repository

import com.jmc.banks.data.remote.model.CardIssuer

internal interface Remote {

    suspend fun getCardIssuers(id: String): List<CardIssuer>
}