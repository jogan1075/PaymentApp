package com.jmc.paymentapp.features.banks.data.source

import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import javax.inject.Inject

class BankSourceFactory @Inject constructor(
    private val remote: BankRemote
) {
    fun getRemote(): BankRemote = remote
}