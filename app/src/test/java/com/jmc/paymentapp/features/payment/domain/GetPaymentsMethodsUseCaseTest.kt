package com.jmc.paymentapp.features.payment.domain

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
import com.jmc.paymentapp.utils.TestFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class GetPaymentsMethodsUseCaseTest{
    private val mockRepository = Mockito.mock(PaymentRepository::class.java)
    private val usecase = GetPaymentsMethodsUseCase(mockRepository)


    private fun stubRepoGetPaymentsMethods(
        resultValue: List<NewPayment>
    ) {
        runBlocking {
            val repositoryMethod = mockRepository.getPaymentsMethods()
            Mockito.`when`(repositoryMethod).thenReturn(resultValue)
        }
    }

    @Test
    fun `given random list, when getPaymentsMethods, then return new list` () {
        runBlocking {

            val response = TestFactory.makePaymentList(1)

            stubRepoGetPaymentsMethods(response)

            val testObserver = usecase.execute()

            assertEquals(testObserver, response)

            Mockito.verify(mockRepository).getPaymentsMethods()
        }
    }


}