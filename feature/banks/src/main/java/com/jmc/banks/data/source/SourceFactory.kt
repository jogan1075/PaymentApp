package com.jmc.banks.data.source

import com.jmc.banks.data.repository.Remote
import javax.inject.Inject

internal class SourceFactory @Inject constructor(
    private val remote: Remote
) {
    fun getRemote(): Remote = remote
}