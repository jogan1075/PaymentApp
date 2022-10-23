package com.jmc.installments.data

import com.jmc.installments.TestFactory
import com.jmc.installments.data.remote.model.InstallmentOption
import com.jmc.installments.data.repository.Remote
import com.jmc.installments.data.source.SourceFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class InstallmentDataRepositoryTest {
    private val remote = mock<Remote>()
    private val factory = SourceFactory(remote)

    private val sutDataRepository = DataRepository(factory)


    private fun stubInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String,
        resultValue: List<InstallmentOption>,
    ) {
        runBlocking {
            whenever(
                remote.getInstallmentsOptions(id, amount, issuerId)
            ).thenReturn(resultValue)
        }
    }

    @Test
    fun `given data random with getInstallmentsOptions success, then Go to stateSuccessful`() {
        runBlocking {
            val dataMock = TestFactory.makeInstallmentOptionList(1)
            val id = RandomFactory.generateString()
            val amount = RandomFactory.generateFloat()
            val issuerId = RandomFactory.generateString()

            stubInstallmentsOptions(
                id = id, amount = amount, issuerId = issuerId,
                resultValue = dataMock
            )

            val testObserver =
                sutDataRepository.getInstallmentsOptions(id, amount, issuerId)

            assertEquals(testObserver, dataMock)
            verify(remote).getInstallmentsOptions(id, amount, issuerId)
        }
    }
}