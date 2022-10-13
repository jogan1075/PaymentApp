package com.jmc.utils.exceptions

open class RepositoryException : RuntimeException {

    private var solution: String? = null
    private val code: Int
    private val detailMessage: String


    constructor (code: Int, detailMessage: String) : super(detailMessage) {
        this.code = code
        this.detailMessage = detailMessage
    }

    constructor (code: Int, detailMessage: String, solution: String) : super(detailMessage) {
        this.code = code
        this.solution = solution
        this.detailMessage = detailMessage
    }

}