package com.jmc.paymentapp.features.installments.data.source

import com.jmc.paymentapp.features.installments.data.repository.InstallmentRemote
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock

class InstallmentFactoryTest{
    private val remote = mock<InstallmentRemote>()
    private val factory = InstallmentFactory(remote)

    @Test
    fun `when getCache, then Remote instance not null`() {
        assertNotNull(factory.getRemote())
    }
}