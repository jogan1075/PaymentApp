package com.jmc.paymentapp.features.installments.data.remote

import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.remote.service.InstallmentsApi
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class InstallmentRemoteImplTest {
    private val restApi = mock<InstallmentsApi>()
    private val remoteImpl = InstallmentRemoteImpl(restApi)

    @Before
    fun setUpCoroutines() {
        MockitoAnnotations.openMocks(this)
    }

    private fun stubRestApiInstallmentsOptions(
        id: String,
        amount: Float,
        issuerId: String,
        single: List<InstallmentOption>
    ) {
        runBlocking {
            whenever(
                restApi.getInstallmentsOptions(id, amount, issuerId)
            ).thenReturn(single)
        }
    }

    @Test
    fun `given data random, when getInstallmentsOptions, then Completes`() {
        runBlocking {
            val dataMock = TestFactory.makeInstallmentOptionList(1)
            val id = RandomFactory.generateString()
            val amount = RandomFactory.generateFloat()
            val issuerId = RandomFactory.generateString()

            stubRestApiInstallmentsOptions(
                id = id,
                amount = amount,
                issuerId = issuerId,
                single = dataMock
            )

            val testObserver =
                remoteImpl.getInstallmentsOptions(id = id, amount = amount, issuerId = issuerId)

            assertEquals(dataMock, testObserver)
        }


    }
}