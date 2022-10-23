package com.jmc.payment.data.source

import com.jmc.payment.data.repository.Remote
import javax.inject.Inject

internal class SourceFactory @Inject constructor(
    private val remote: Remote
) {
    fun getRemote(): Remote = remote
}