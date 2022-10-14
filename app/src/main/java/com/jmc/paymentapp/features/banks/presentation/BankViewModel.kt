package com.jmc.paymentapp.features.banks.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.jmc.mvi.BaseVM
import com.jmc.paymentapp.features.banks.domain.GetCardIssuersUseCase
import com.jmc.paymentapp.features.banks.presentation.contract.BankContract
import com.jmc.utils.errors.DomainError
import com.jmc.utils.exceptions.RepositoryCoroutineHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankViewModel @Inject constructor(
    private val userUseCase: GetCardIssuersUseCase,
    stateHandle: SavedStateHandle
) :
    BaseVM<BankContract.Event, BankContract.State>(stateHandle) {

    override fun setInitialState(): BankContract.State {
        return BankContract.State()
    }

    override fun handleEvents(intent: BankContract.Event) {
        when (intent) {
            is BankContract.Event.IdPayment -> {
                viewModelScope.launch(RepositoryCoroutineHandler(::handleError)) {
                    setState { copy(isLoading = true).clearErrors() }
                    val persons =     userUseCase.execute(intent.idPayment)
                    setState { copy(isLoading = false, list = persons) }
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