package com.jmc.paymentapp.features.installments.data.source

import com.jmc.paymentapp.features.installments.data.repository.InstallmentRemote
import javax.inject.Inject

class InstallmentFactory @Inject constructor(
    private val remote: InstallmentRemote
) {
    fun getRemote(): InstallmentRemote = remote
}