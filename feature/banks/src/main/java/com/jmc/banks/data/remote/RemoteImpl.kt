package com.jmc.banks.data.remote

import com.jmc.banks.data.remote.model.CardIssuer
import com.jmc.banks.data.remote.service.ApiService
import com.jmc.banks.data.repository.Remote
import javax.inject.Inject

internal class RemoteImpl @Inject constructor(private val apiService: ApiService) : Remote {
    
    override suspend fun getCardIssuers(id: String): List<CardIssuer> {
        return apiService.getCardIssuers(id)
    }
}