package com.jmc.paymentapp.features.installments.data

import com.jmc.paymentapp.features.banks.data.BankDataRepository
import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import com.jmc.paymentapp.features.banks.data.source.BankSourceFactory
import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.repository.InstallmentRemote
import com.jmc.paymentapp.features.installments.data.source.InstallmentFactory
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class InstallmentDataRepositoryTest {
    private val remote = mock<InstallmentRemote>()
    private val factory = InstallmentFactory(remote)

    private val sutDataRepository = InstallmentDataRepository(factory)


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