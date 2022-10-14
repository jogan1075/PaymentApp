package com.jmc.paymentapp.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jmc.paymentapp.features.amount.AmountScreen
import com.jmc.paymentapp.features.banks.BankScreen
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
            Screens.PaymentMethodScreen.route + "?param={amount}")
         { backStackEntry ->
            PaymentMethodScreen(
                navController = navController,
                monto = backStackEntry.arguments?.getString("amount")
                    .toString()
            )
        }

        composable(
            Screens.BankListScreen.route + "?param={id}")
        { backStackEntry ->
            BankScreen(
                navController = navController,
                idPayment = backStackEntry.arguments?.getString("id")
                    .toString()
            )
        }


        /* composable(Screen.RegisterScreen.route) {
             RegisterScreen(navController = navController)
         }

         composable(Screen.LoginScreen.route) {
             LoginScreen(navController = navController, activity = activity)
         }

         composable(Screen.ForgotPasswordScreen.route) {
             ForgotPasswordScreen(navController = navController)
         }

         composable(Screen.HomeScreen.route) {
             Dashboard(navController = navController)
         }
         composable(Screen.PopularListScreen.route) {
             PopularListScreen(navController = navController)
         }
         composable(
             Screen.DetailsScreen.route,
             arguments = listOf(navArgument("params") { type = NavType.StringType })
         ) { backStackEntry ->
             FlowerDetailsScreen(
                 navController = navController, backStackEntry.arguments?.getString("params")
                     .toString()
             )
         }
         composable(Screen.AddToCartScreen.route) {
             CheckoutScreen()
         }*/
    }

}
