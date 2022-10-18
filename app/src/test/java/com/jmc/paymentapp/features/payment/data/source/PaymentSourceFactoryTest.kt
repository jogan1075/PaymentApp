package com.jmc.paymentapp.features.payment.data.source

import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.mock

class PaymentSourceFactoryTest{
    private val remote = mock<PaymentRemote>()
    private val factory = PaymentSourceFactory(remote)

    @Test
    fun `when getCache, then Remote instance not null`() {
        assertNotNull(factory.getRemote())
    }
}