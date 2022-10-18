package com.jmc.paymentapp.features.banks.presentation.contract

import com.jmc.mvi.ViewEvent
import com.jmc.mvi.ViewSideEffect
import com.jmc.mvi.ViewState
import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer

class BankContract {

    sealed class Event : ViewEvent {
        data class IdPayment(val idPayment: String) : Event()
    }

    data class State(
        override val isLoading: Boolean = false,
        val list: List<CardIssuer>? = listOf(),
        val error: String? = null
    ) : ViewState {

        override fun getErrorMessage() = error

        override fun clearErrors(): State {
            return copy(error = null, list = emptyList())
        }
    }

    sealed class Effect : ViewSideEffect {

    }
}