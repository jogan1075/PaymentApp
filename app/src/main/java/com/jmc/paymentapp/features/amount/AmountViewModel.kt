package com.jmc.paymentapp.features.amount

import androidx.lifecycle.SavedStateHandle
import com.jmc.mvi.BaseVM
import com.jmc.paymentapp.features.amount.contract.AmountContract
import com.jmc.utils.errors.DomainError
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AmountViewModel @Inject constructor(stateHandle: SavedStateHandle) :
    BaseVM<AmountContract.Event, AmountContract.State>(stateHandle) {


    override fun setInitialState(): AmountContract.State {
        return AmountContract.State()
    }

    override fun handleEvents(intent: AmountContract.Event) {
        when (intent) {
//            is CastContract.Event.UserLogin -> {
//                viewModelScope.launch(RepositoryCoroutineHandler(::handleError)) {
//                    setState { copy(isLoading = true).clearErrors() }
////                    userUseCase.execute("")
////                    goToDashboard()
//                    setState { copy(isLoading = false) }
//                }
//            }
//            is CastContract.Event.EmailChanged -> setState { copy(email = intent.email).clearErrors() }
//            is CastContract.Event.PasswordChanged -> setState { copy(password = intent.password).clearErrors() }
//            is CastContract.Event.NavControllerEvent -> setState { copy(navController = intent.navController).clearErrors() }
            is AmountContract.Event.AmountChanged -> setState { copy(amount = intent.amount).clearErrors() }
        }
    }

    private fun handleError(domainError: DomainError) {
        setState { copy(isLoading = false, error = "error =)") }
    }
}