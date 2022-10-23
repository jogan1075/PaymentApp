package com.jmc.installments.data.source

import com.jmc.installments.data.repository.Remote
import javax.inject.Inject

internal class SourceFactory @Inject constructor(
    private val remote: Remote
) {
    fun getRemote(): Remote = remote
}