package com.jmc.amount.contract

import com.jmc.mvi.ViewEvent
import com.jmc.mvi.ViewSideEffect
import com.jmc.mvi.ViewState

class AmountContract {

    sealed class Event : ViewEvent {
        data class AmountChanged(val amount: String) : Event()
    }

    data class State(
        override val isLoading: Boolean = false,
        val amount: String? = null,
        val errorAmount: String? = null,
        val error: String? = null
    ) : ViewState {

        override fun getErrorMessage() = error

        override fun clearErrors(): State {
            return copy(error = null, errorAmount = null)
        }
    }

    sealed class Effect : ViewSideEffect {

    }
}