package com.jmc.paymentapp.features.installments.domain.mapper

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.remote.model.PayerCost
import com.jmc.paymentapp.features.installments.domain.model.InstallmentModelUi
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI
import javax.inject.Inject

class PlayerCostListMapper @Inject constructor() {
    /* override fun map(input: InstallmentOption) = InstallmentModelUi(
         recommendedMessage = input.payerCosts.map { cast -> cast.recommendedMessage }
     )*/

    fun List<PayerCost>.fromRemoteToDomain(): List<PayerCostUI> {
        return map { it.fromRemoteToDomain() }
    }

    private fun PayerCost.fromRemoteToDomain(): PayerCostUI {
        return PayerCostUI(
            recommendedMessage = recommendedMessage,
            paymentMethodOptionId = paymentMethodOptionId
        )
    }
}

