package com.jmc.banks.domain

import com.jmc.banks.TestFactory
import com.jmc.banks.data.remote.model.CardIssuer
import com.jmc.banks.domain.repository.Repository
import com.jmc.utils.RandomFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class GetCardIssuersUseCaseTest{

    private val mockRepository = Mockito.mock(Repository::class.java)
    private val usecase = GetCardIssuersUseCase(mockRepository)


    private fun stubRepoGetPaymentsMethods(
        id:String,
        resultValue: List<CardIssuer>
    ) {
        runBlocking {
            val repositoryMethod = mockRepository.getCardIssuers(id)
            Mockito.`when`(repositoryMethod).thenReturn(resultValue)
        }
    }

    @Test
    fun `given random id, when getCardIssuers, then return new list` () {
        runBlocking {

            val dataMock = TestFactory.makeCardIssuerList(1)
            val id = RandomFactory.generateString()

            stubRepoGetPaymentsMethods(id,dataMock)

            val testObserver = usecase.execute(id)

            assertEquals(testObserver, dataMock)

            Mockito.verify(mockRepository).getCardIssuers(id)
        }
    }

}