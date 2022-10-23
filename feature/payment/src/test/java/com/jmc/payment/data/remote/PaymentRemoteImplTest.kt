package com.jmc.payment.data.remote

import com.jmc.payment.TestFactory.makePaymentList
import com.jmc.payment.data.remote.models.NewPayment
import com.jmc.payment.data.remote.service.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class PaymentRemoteImplTest {
    private val restApi = mock<ApiService>()
    private val remoteImpl = PaymentRemoteImpl(restApi)

    @Before
    fun setUpCoroutines() {
        MockitoAnnotations.openMocks(this)
    }

    private suspend fun stubRestApiPaymentMethods(
        single: List<NewPayment>
    ) {
        whenever(
            restApi.paymentMethods()
        ).thenReturn(single)
    }

    @Test
     fun `given get service, when getPaymentMethods, then Completes`() {
        runBlocking {
            val makeRemoteTopCategoriesResponse = makePaymentList(1)
            stubRestApiPaymentMethods(
                single = makeRemoteTopCategoriesResponse
            )

            val testObserver = remoteImpl.getPaymentsMethods()

            assertEquals(makeRemoteTopCategoriesResponse, testObserver)
        }


    }
}