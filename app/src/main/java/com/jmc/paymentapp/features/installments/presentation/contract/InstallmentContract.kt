package com.jmc.paymentapp.features.installments.presentation.contract

import com.jmc.mvi.ViewEvent
import com.jmc.mvi.ViewSideEffect
import com.jmc.mvi.ViewState
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI

class InstallmentContract {

    sealed class Event : ViewEvent {
        data class CallInstallments(
            val amount: String,
            val idPayment: String,
            val issuerId: String
        ) : Event()
    }

    data class State(
        override val isLoading: Boolean = false,
        val list: List<PayerCostUI>? = listOf(),
        val idPayment: String? = null,
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