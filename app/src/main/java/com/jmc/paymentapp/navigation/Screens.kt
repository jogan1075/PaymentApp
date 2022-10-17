package com.jmc.paymentapp.navigation

sealed class Screens (val route: String){
    object SplashScreen : Screens("splash_screen")

    object AmountScreen : Screens("amount_screen")

    object PaymentMethodScreen : Screens("paymentmethod_screen/{amount}")

    object BankListScreen : Screens("bank_screen/{IdPayment}")

    object InstallmentsScreen : Screens("installments_screen/{params}")

    object ResumeScreen : Screens("add_to_cart_screen")


}