package com.jmc.banks.data.source

import com.jmc.banks.data.repository.Remote
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock

class BankSourceFactoryTest{
    private val remote = mock<Remote>()
    private val factory = SourceFactory(remote)

    @Test
    fun `when getCache, then Remote instance not null`() {
        assertNotNull(factory.getRemote())
    }
}