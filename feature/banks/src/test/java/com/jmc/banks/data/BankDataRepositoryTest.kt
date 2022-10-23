package com.jmc.banks.data

import com.jmc.banks.TestFactory
import com.jmc.banks.data.remote.model.CardIssuer
import com.jmc.banks.data.repository.Remote
import com.jmc.banks.data.source.SourceFactory
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class BankDataRepositoryTest {
    private val remote = mock<Remote>()
    private val factory = SourceFactory(remote)

    private val sutDataRepository = DataRepository(factory)


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