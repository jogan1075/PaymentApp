package com.jmc.payment.presentation

import androidx.lifecycle.SavedStateHandle
import com.jmc.payment.domain.GetPaymentsMethodsUseCase
import com.jmc.payment.presentation.contract.PaymentContract
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.paymentapp.utils.helper.CoroutineTest
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

class PaymentViewModelTest : CoroutineTest() {

    @Mock
    lateinit var stateHandle: SavedStateHandle

    @Mock
    lateinit var usecase: GetPaymentsMethodsUseCase


    @InjectMocks
    lateinit var viewModel: PaymentViewModel


    @Test
    fun handleEvents_givenEventCallService_whenUseCase_shouldSuccessData() {
        runBlockingTest {
            val dataMock= TestFactory.makePaymentList(1)
            whenever(usecase.execute()).thenReturn(dataMock)
            viewModel = PaymentViewModel(usecase, stateHandle)

            viewModel.setEvent(PaymentContract.Event.CallService)

            dispatcher.scheduler.advanceUntilIdle()

            val expectedState = PaymentContract.State(
                isLoading = false,
                list = dataMock,
                error = null
            )

            val state = viewModel.state

            state shouldBe expectedState
        }
    }


}