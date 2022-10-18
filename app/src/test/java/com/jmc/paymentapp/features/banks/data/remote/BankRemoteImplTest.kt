package com.jmc.paymentapp.features.banks.data.remote

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.remote.service.BankApi
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class BankRemoteImplTest {

    private val restApi = mock<BankApi>()
    private val remoteImpl = BankRemoteImpl(restApi)

    @Before
    fun setUpCoroutines() {
        MockitoAnnotations.openMocks(this)
    }

    private fun stubRestApiPaymentMethods(
        id: String,
        single: List<CardIssuer>
    ) {
        runBlocking {
            whenever(
                restApi.getCardIssuers(id)
            ).thenReturn(single)
        }
    }

    @Test
     fun `given id random, when getCardIssuers, then Completes`() {
        runBlocking {
            val dataMock = TestFactory.makeCardIssuerList(1)
            val id = RandomFactory.generateString()

            stubRestApiPaymentMethods(
                id = id,
                single = dataMock
            )

            val testObserver = remoteImpl.getCardIssuers(id)

            assertEquals(dataMock, testObserver)
        }


    }

}