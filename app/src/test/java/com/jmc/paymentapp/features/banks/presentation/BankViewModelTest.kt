package com.jmc.paymentapp.features.banks.presentation

import androidx.lifecycle.SavedStateHandle
import com.jmc.paymentapp.features.banks.domain.GetCardIssuersUseCase
import com.jmc.paymentapp.features.banks.presentation.contract.BankContract
import com.jmc.paymentapp.features.payment.domain.GetPaymentsMethodsUseCase
import com.jmc.paymentapp.features.payment.presentation.PaymentViewModel
import com.jmc.paymentapp.features.payment.presentation.contract.PaymentContract
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.paymentapp.utils.helper.CoroutineTest
import com.jmc.utils.RandomFactory
import io.kotest.matchers.shouldBe
import org.junit.Assert.*
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

class BankViewModelTest : CoroutineTest() {

    @Mock
    lateinit var stateHandle: SavedStateHandle

    @Mock
    lateinit var usecase: GetCardIssuersUseCase


    @InjectMocks
    lateinit var viewModel: BankViewModel


    @Test
    fun handleEvents_givenEventCallService_whenUseCase_shouldSuccessData() {
        runBlockingTest {
            val dataMock= TestFactory.makeCardIssuerList(1)
            val id= RandomFactory.generateString()
            whenever(usecase.execute(id)).thenReturn(dataMock)
            viewModel = BankViewModel(usecase, stateHandle)

            viewModel.setEvent(BankContract.Event.IdPayment(id))

            dispatcher.scheduler.advanceUntilIdle()

            val expectedState = BankContract.State(
                isLoading = false,
                list = dataMock,
                error = null
            )

            val state = viewModel.state

            state shouldBe expectedState
        }
    }

}