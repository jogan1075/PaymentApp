package com.jmc.amount

import androidx.lifecycle.SavedStateHandle
import com.jmc.amount.contract.AmountContract
import com.jmc.mvi.BaseVM
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
            is AmountContract.Event.AmountChanged -> setState { copy(amount = intent.amount).clearErrors() }
        }
    }
}