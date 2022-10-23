package com.jmc.payment.presentation.contract

import com.jmc.mvi.ViewEvent
import com.jmc.mvi.ViewSideEffect
import com.jmc.mvi.ViewState
import com.jmc.payment.data.remote.models.NewPayment

class PaymentContract {

    sealed class Event : ViewEvent {
        object CallService : Event()
    }

    data class State(
        override val isLoading: Boolean = false,
        val list: List<NewPayment>? = listOf(),
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