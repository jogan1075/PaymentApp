package com.jmc.paymentapp.features.banks.domain.mapper

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.banks.domain.model.BankModelUi
import com.jmc.utils.Mapper
import javax.inject.Inject

class BankMapper @Inject constructor() : Mapper<CardIssuer, BankModelUi> {
    override fun map(input: CardIssuer) = BankModelUi(
        id = input.id,
        name = input.name,
        secureThumbnail = input.secureThumbnail,
        thumbnail = input.thumbnail

    )
}

