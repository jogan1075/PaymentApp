package com.jmc.installments.data.source

import com.jmc.installments.data.repository.Remote
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock

class InstallmentFactoryTest{
    private val remote = mock<Remote>()
    private val factory = SourceFactory(remote)

    @Test
    fun `when getCache, then Remote instance not null`() {
        assertNotNull(factory.getRemote())
    }
}