package com.jmc.paymentapp.navigation

sealed class Screens (val route: String){

    object AmountScreen : Screens("amount_screen")

    object PaymentMethodScreen : Screens("paymentmethod_screen")

    object BankListScreen : Screens("bank_screen")

    object InstallmentsScreen : Screens("installments_screen")

    object ResumeScreen : Screens("resume")


}