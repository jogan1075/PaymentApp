package com.jmc.navigation

interface NavigationProvider {
    fun navigateToInstallments(
        idPayment: String,
        amount: String,
        idIssuer: String,
        namePayment: String,
        nameBank: String,
        img: String
    )
    fun navigateToBankList(id: String, name: String, amount: String)
    fun navigateToSuccess(
        amount: String,
        namePayment: String,
        nameBank: String,
        image: String,
        msg: String
    )
    fun navigateToPayment(amount: String)
    fun navigateToAmount()
    fun navigateUp()
}