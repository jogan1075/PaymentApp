package com.jmc.paymentapp.features.payment.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.jmc.mvi.BaseVM
import com.jmc.paymentapp.features.payment.domain.GetPaymentsMethodsUseCase
import com.jmc.paymentapp.features.payment.presentation.contract.PaymentContract
import com.jmc.utils.errors.DomainError
import com.jmc.utils.exceptions.RepositoryCoroutineHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val userUseCase: GetPaymentsMethodsUseCase,
    stateHandle: SavedStateHandle
) :
    BaseVM<PaymentContract.Event, PaymentContract.State>(stateHandle) {

    override fun setInitialState(): PaymentContract.State {
        return PaymentContract.State()
    }

    override fun handleEvents(intent: PaymentContract.Event) {
        when(intent){
            PaymentContract.Event.CallService -> {
                viewModelScope.launch(RepositoryCoroutineHandler(::handleError)) {
                    setState { copy(isLoading = true).clearErrors() }
                    val listPayments =  userUseCase.execute()
                    setState { copy(isLoading = false, list = listPayments) }
                }
            }
        }
    }

    private fun handleError(domainError: DomainError) {
        setState { copy(isLoading = false, error = "error =)") }
    }

    private fun launch(invoke: suspend () -> Unit) {
        viewModelScope.launch(RepositoryCoroutineHandler(::handleError)) {
            invoke()
        }
    }

}