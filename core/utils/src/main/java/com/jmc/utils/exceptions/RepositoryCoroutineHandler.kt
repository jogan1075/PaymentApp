package com.jmc.utils.exceptions


import com.jmc.utils.errors.DomainError
import com.jmc.utils.errors.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class RepositoryCoroutineHandler(
    private val handler: (DomainError) -> Unit
) : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        when (exception) {
            is NoConnectionException -> handler(DomainError.NoConnectionError)
            is SessionExpiredException -> handler(DomainError.SessionExpired)
            is WrongCredentialsException -> handler(DomainError.WrongCredentials)
            is RepositoryException -> handler(DomainError.ServiceError)
            else -> {
                Logger.error("Repository Coroutine unmanaged error: \n ${exception.stackTraceToString()}")
                handler(DomainError.ServiceError)
            }
        }
    }
}