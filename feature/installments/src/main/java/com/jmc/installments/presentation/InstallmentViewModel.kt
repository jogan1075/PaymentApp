package com.jmc.installments.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.jmc.mvi.BaseVM
import com.jmc.installments.domain.GetInstallmentsUseCase
import com.jmc.paymentapp.features.installments.presentation.contract.InstallmentContract
import com.jmc.utils.errors.DomainError
import com.jmc.utils.exceptions.RepositoryCoroutineHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class InstallmentViewModel @Inject constructor(
    private val userUseCase: GetInstallmentsUseCase,
    stateHandle: SavedStateHandle
) :
    BaseVM<InstallmentContract.Event, InstallmentContract.State>(stateHandle) {

    override fun setInitialState(): InstallmentContract.State {
        return InstallmentContract.State()
    }

    override fun handleEvents(intent: InstallmentContract.Event) {
        when (intent) {
            is InstallmentContract.Event.CallInstallments -> {
                viewModelScope.launch(RepositoryCoroutineHandler(::handleError)) {
                    setState { copy(isLoading = true).clearErrors() }
                    val quotas = userUseCase.execute(
                        id = intent.idPayment,
                        amount = intent.amount.toDouble(),
                        issuerId = intent.issuerId
                    )
                    setState { copy(isLoading = false, list = quotas) }
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