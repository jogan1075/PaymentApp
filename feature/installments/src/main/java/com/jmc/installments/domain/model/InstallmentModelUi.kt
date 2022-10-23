package com.jmc.paymentapp.features.installments.domain.model

import com.jmc.installments.data.remote.model.Issuer
import com.jmc.installments.data.remote.model.PayerCost

data class InstallmentModelUi(
    val issuer: Issuer,
    val payerCosts: List<PayerCost>
)



