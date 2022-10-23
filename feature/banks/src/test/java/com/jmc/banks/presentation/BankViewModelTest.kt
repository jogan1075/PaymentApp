package com.jmc.banks.presentation

import androidx.lifecycle.SavedStateHandle
import com.jmc.banks.domain.GetCardIssuersUseCase

import com.jmc.banks.TestFactory
import com.jmc.utils.RandomFactory
import com.jmc.utils.testing.CoroutineTest
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

class BankViewModelTest : CoroutineTest() {

    @Mock
    lateinit var stateHandle: SavedStateHandle

    @Mock
    internal lateinit var usecase: GetCardIssuersUseCase


    @InjectMocks
    internal lateinit var viewModel: BankViewModel


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