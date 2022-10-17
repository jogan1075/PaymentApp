package com.jmc.paymentapp.features.installments.domain.model

import com.jmc.paymentapp.features.installments.data.remote.model.PayerCost

data class InstallmentModelUi(
    val payerCosts: List<PayerCost>
)
