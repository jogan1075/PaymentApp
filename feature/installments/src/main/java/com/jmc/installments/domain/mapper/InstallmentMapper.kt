package com.jmc.paymentapp.features.installments.domain.mapper

import com.jmc.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.domain.model.InstallmentModelUi
import com.jmc.utils.Mapper
import javax.inject.Inject

class InstallmentMapper @Inject constructor() :
    Mapper<InstallmentOption, InstallmentModelUi> {

    override fun map(input: InstallmentOption) =
        InstallmentModelUi(issuer = input.issuer, payerCosts = input.payerCosts)

}

