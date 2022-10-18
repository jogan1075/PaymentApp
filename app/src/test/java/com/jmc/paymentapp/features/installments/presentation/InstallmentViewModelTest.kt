package com.jmc.paymentapp.features.installments.presentation

import androidx.lifecycle.SavedStateHandle
import com.jmc.paymentapp.features.installments.domain.GetInstallmentsUseCase
import com.jmc.paymentapp.features.installments.presentation.contract.InstallmentContract
import com.jmc.paymentapp.utils.TestFactory
import com.jmc.paymentapp.utils.helper.CoroutineTest
import com.jmc.utils.RandomFactory
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

class InstallmentViewModelTest: CoroutineTest() {

    @Mock
    lateinit var stateHandle: SavedStateHandle

    @Mock
    lateinit var usecase: GetInstallmentsUseCase


    @InjectMocks
    lateinit var viewModel: InstallmentViewModel




    @Test
    fun handleEvents_givenEventCallService_whenUseCase_shouldSuccessData() {
        runBlockingTest {
            val dataMock = TestFactory.makePayerCostUIList(1)
            val id = RandomFactory.generateString()
            val amount = RandomFactory.generateDouble()
            val issuerId = RandomFactory.generateString()

            whenever(usecase.execute(id, amount, issuerId)).thenReturn(dataMock)
            viewModel = InstallmentViewModel(usecase, stateHandle)

            viewModel.setEvent(InstallmentContract.Event.CallInstallments(amount.toString(),id,issuerId))

            dispatcher.scheduler.advanceUntilIdle()

            val expectedState = InstallmentContract.State(
                isLoading = false,
                list = dataMock,
                error = null
            )

            val state = viewModel.state

            state shouldBe expectedState
        }
    }

}