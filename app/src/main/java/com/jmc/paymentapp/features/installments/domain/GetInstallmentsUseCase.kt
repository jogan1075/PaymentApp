package com.jmc.paymentapp.features.installments.domain


import com.jmc.paymentapp.features.installments.domain.mapper.InstallmentMapper
import com.jmc.paymentapp.features.installments.domain.mapper.PlayerCostListMapper
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI
import com.jmc.paymentapp.features.installments.domain.repository.InstallmentRepository
import javax.inject.Inject

class GetInstallmentsUseCase @Inject constructor(
    private val repository: InstallmentRepository,
    private val mapper: PlayerCostListMapper,
    private val mapper1: InstallmentMapper
) {

    suspend fun execute(id: String, amount: Double, issuerId: String?): List<PayerCostUI>? {
        var retorno: List<PayerCostUI>? =null
        val rep = repository.getInstallmentsOptions(id, amount.toFloat(), issuerId!!).body()
            ?.map(mapper1::map)

        val ext = rep?.map { installmentModelUi ->
            with(mapper) {
                retorno = installmentModelUi.payerCosts.fromRemoteToDomain()
            }
        }

        return retorno

    }

}