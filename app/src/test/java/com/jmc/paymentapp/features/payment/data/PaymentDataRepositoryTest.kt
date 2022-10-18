package com.jmc.paymentapp.features.payment.data

import com.jmc.paymentapp.features.payment.data.remote.models.NewPayment
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import com.jmc.paymentapp.features.payment.data.source.PaymentSourceFactory
import com.jmc.paymentapp.utils.TestFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class PaymentDataRepositoryTest {


    private val remote = mock<PaymentRemote>()
    private val factory = PaymentSourceFactory(remote)

    private val sutDataRepository = PaymentDataRepository(factory)


    private fun stubgetPayments(
        resultValue: List<NewPayment>,
    ) {
        runBlocking {
            whenever(
                remote.getPaymentsMethods()
            ).thenReturn(resultValue)
        }
    }

    @Test
    fun `given data with getPaymentsMethods success, then Go to stateSuccessful`() {
        runBlocking {
            val dataMock = TestFactory.makePaymentList(1)

            stubgetPayments(
                resultValue = dataMock
            )

            val testObserver =
                sutDataRepository.getPaymentsMethods()

            assertEquals(testObserver, dataMock)
            verify(remote).getPaymentsMethods()
        }
    }

}