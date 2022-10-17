package com.jmc.paymentapp.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jmc.paymentapp.features.amount.AmountScreen
import com.jmc.paymentapp.features.banks.BankScreen
import com.jmc.paymentapp.features.installments.view.InstallmentScreen
import com.jmc.paymentapp.features.payment.view.PaymentMethodScreen

@Composable
fun Navigation(activity: Activity) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.AmountScreen.route
    ) {

        composable(Screens.AmountScreen.route) {
            AmountScreen(navController = navController)
        }

        composable(
            Screens.PaymentMethodScreen.route + "?param={amount}"
        )
        { backStackEntry ->
            PaymentMethodScreen(
                navController = navController,
                monto = backStackEntry.arguments?.getString("amount")
                    .toString()
            )
        }

        composable(
            Screens.BankListScreen.route + "?param={idPayment},{namePayment},{amount}"
        )
        { backStackEntry ->
            BankScreen(
                navController = navController,
                idPayment = backStackEntry.arguments?.getString("idPayment")
                    .toString(),
                amount = backStackEntry.arguments?.getString("amount")
                    .toString(),
                namePayment = backStackEntry.arguments?.getString("namePayment")
                    .toString()
            )
        }

        composable(
            Screens.InstallmentsScreen.route + "?param={idPayment},{amount},{issuerId},{namePayment}"
        )
        { backStackEntry ->
            InstallmentScreen(
                navController = navController,
                idPayment = backStackEntry.arguments?.getString("idPayment")
                    .toString(),
                monto = backStackEntry.arguments?.getString("amount")
                    .toString(),
                issuerId = backStackEntry.arguments?.getString("issuerId")
                    .toString(),
                namePayment = backStackEntry.arguments?.getString("namePayment")
                    .toString()
            )
        }

    }

}
