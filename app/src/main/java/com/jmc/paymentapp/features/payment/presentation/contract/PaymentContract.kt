package com.jmc.paymentapp.features.payment.presentation.contract

import com.jmc.mvi.ViewEvent
import com.jmc.mvi.ViewSideEffect
import com.jmc.mvi.ViewState
import com.jmc.paymentapp.features.payment.domain.model.PaymentModelUi

class PaymentContract {

    sealed class Event : ViewEvent {
        object GetPaymentMethod : Event()
        data class AmountChanged(val amount: String) : Event()
//        data class NavControllerEvent(val navController: NavController) : Event()
    }

    data class State(
        override val isLoading: Boolean = false,
        /*val isLoading: Boolean = false,*/
        val list: List<PaymentModelUi>? = listOf(),
        val idPayment: String? = null,
//        val navController: NavController? =null,
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