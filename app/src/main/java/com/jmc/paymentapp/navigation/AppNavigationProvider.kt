package com.jmc.paymentapp.navigation

import androidx.navigation.NavController
import com.jmc.amount.destinations.AmountScreenDestination
import com.jmc.banks.view.destinations.BankScreenDestination
import com.jmc.finished.destinations.SucessScreenDestination
import com.jmc.installments.view.destinations.InstallmentScreenDestination
import com.jmc.navigation.NavigationProvider
import com.jmc.payment.view.destinations.PaymentMethodScreenDestination
import com.ramcosta.composedestinations.navigation.navigateTo

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
        return navController.navigateTo(
            InstallmentScreenDestination(
                amount = amount,
                idPayment = idPayment,
                namePayment = namePayment,
                image = img,
                nameBank = nameBank,
                issuerId = idIssuer
            )
        )
    }

    override fun navigateToBankList(id: String, name: String, amount: String) {
        return navController.navigateTo(
            BankScreenDestination(
                idPayment = id,
                namePayment = name,
                amount = amount
            )
        )
    }

    override fun navigateToSuccess(
        amount: String,
        namePayment: String,
        nameBank: String,
        image: String,
        msg: String
    ) {
        return navController.navigateTo(
            SucessScreenDestination(
                amount = amount,
                namePayment = namePayment,
                nameBank = nameBank,
                image = image,
                nameRecomendMessage = msg
            )
        )
    }

    override fun navigateToPayment(amount: String) {
        return navController.navigateTo(PaymentMethodScreenDestination(amount = amount))
    }

    override fun navigateToAmount() {
        return navController.navigateTo(AmountScreenDestination)
    }


    override fun navigateUp() {
        navController.navigateUp()
    }
}