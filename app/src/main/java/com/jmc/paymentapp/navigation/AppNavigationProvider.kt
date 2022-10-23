package com.jmc.paymentapp.navigation

import androidx.navigation.NavController
import com.jmc.navigation.NavigationProvider

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {
    override fun navigateToInstallments(
        idPayment: String,
        amount: String,
        idIssuer: String,
        namePayment: String,
        nameBank: String,
        img: String
    ) {
        TODO("Not yet implemented")
    }

    override fun navigateToBankList(id: String, name: String, amount: String) {
        TODO("Not yet implemented")
    }

    override fun navigateToSuccess(
        amount: String,
        namePayment: String,
        nameBank: String,
        image: String,
        msg: String
    ) {
        TODO("Not yet implemented")
    }

    override fun navigateToPayment(amount: String) {
        TODO("Not yet implemented")
    }

    override fun navigateToAmount() {
        TODO("Not yet implemented")
    }


    override fun navigateUp() {
        navController.navigateUp()
    }
}