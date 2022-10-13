package com.jmc.paymentapp.features.payment.data.source

import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import javax.inject.Inject

class PaymentSourceFactory @Inject constructor(
    private val remote: PaymentRemote
) {
    fun getRemote(): PaymentRemote = remote
}