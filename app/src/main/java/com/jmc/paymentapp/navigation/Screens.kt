package com.jmc.paymentapp.navigation

sealed class Screens (val route: String){
    object SplashScreen : Screens("splash_screen")
    object AmountScreen : Screens("amount_screen")
    object PaymentMethodScreen : Screens("paymentmethod_screen/{amount}"){
        fun addArgument(params: String) = "paymentmethod_screen/$params"
    }
    object BanksScreen : Screens("bank_screen"){
        fun addArgument(params: String) = "details_screen/$params"
    }
    object InstallmentsScreen : Screens("installments_screen/{params}") {
        fun addArgument(params: String) = "details_screen/$params"
    }

    object ResumeScreen : Screens("add_to_cart_screen")


}