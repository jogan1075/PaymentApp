package com.jmc.paymentapp.features.banks.data.source

import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock

class BankSourceFactoryTest{
    private val remote = mock<BankRemote>()
    private val factory = BankSourceFactory(remote)

    @Test
    fun `when getCache, then Remote instance not null`() {
        assertNotNull(factory.getRemote())
    }
}