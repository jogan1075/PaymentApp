package com.jmc.installments.domain


import com.jmc.paymentapp.features.installments.domain.mapper.InstallmentMapper
import com.jmc.paymentapp.features.installments.domain.mapper.PlayerCostListMapper
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI
import com.jmc.installments.domain.repository.Repository
import javax.inject.Inject

internal class GetInstallmentsUseCase @Inject constructor(
    private val repository: Repository,
    private val mapper: PlayerCostListMapper,
    private val mapper1: InstallmentMapper
) {

    suspend fun execute(id: String, amount: Double, issuerId: String?): List<PayerCostUI>? {
        var retorno: List<PayerCostUI>? =null
        val rep = repository.getInstallmentsOptions(id, amount.toFloat(), issuerId!!).map(mapper1::map)

        val ext = rep.map { item ->
            with(mapper) {
                retorno = item.payerCosts.fromRemoteToDomain()
            }
        }

        return retorno

    }

}