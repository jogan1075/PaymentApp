package com.jmc.paymentapp.features.banks.data

import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import com.jmc.paymentapp.features.banks.data.source.BankSourceFactory
import com.jmc.paymentapp.features.payment.data.PaymentDataRepository
import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import com.jmc.paymentapp.features.payment.data.source.PaymentSourceFactory
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class BankDataRepositoryTest {
    private val remote = mock<BankRemote>()
    private val factory = BankSourceFactory(remote)

    private val sutDataRepository = BankDataRepository(factory)


    private fun stubGetCardIssuers(
        id: String,
        resultValue: List<CardIssuer>,
    ) {
        runBlocking {
            whenever(
                remote.getCardIssuers(id)
            ).thenReturn(resultValue)
        }
    }

    @Test
    fun `given data with getCardIssuers success, then Go to stateSuccessful`() {
        runBlocking {
            val dataMock = TestFactory.makeCardIssuerList(1)
            val id = RandomFactory.generateString()

            stubGetCardIssuers(
                id = id,
                resultValue = dataMock
            )

            val testObserver =
                sutDataRepository.getCardIssuers(id)

            assertEquals(testObserver, dataMock)
            verify(remote).getCardIssuers(id)
        }
    }
}