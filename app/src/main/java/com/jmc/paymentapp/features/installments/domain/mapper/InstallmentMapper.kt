package com.jmc.paymentapp.features.installments.domain.mapper

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.banks.domain.model.BankModelUi
import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.domain.model.InstallmentModelUi
import com.jmc.utils.Mapper
import javax.inject.Inject

class InstallmentMapper @Inject constructor() :
    Mapper<InstallmentOption, InstallmentModelUi> {

    override fun map(input: InstallmentOption) = InstallmentModelUi(payerCosts = input.payerCosts)

}

