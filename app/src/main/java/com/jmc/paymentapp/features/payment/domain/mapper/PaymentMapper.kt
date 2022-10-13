package com.jmc.paymentapp.features.payment.domain.mapper

import com.jmc.paymentapp.features.payment.data.remote.models.Payment
import com.jmc.paymentapp.features.payment.domain.model.PaymentModelUi
import com.jmc.utils.Mapper
import javax.inject.Inject

class PaymentMapper @Inject constructor() : Mapper<Payment, PaymentModelUi> {
    override fun map(input: Payment) = PaymentModelUi(
        id = input.id,
        name = input.name,
        status = input.status,
        secureThumbnail = input.secureThumbnail,
        thumbnail = input.thumbnail

    )
}

